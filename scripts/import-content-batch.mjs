import { access, mkdir, readFile, writeFile } from 'node:fs/promises'
import { dirname, join, relative, resolve } from 'node:path'
import { pathToFileURL } from 'node:url'
import { contentRoot, loadCatalog, problemDirectoryName, projectRoot } from './content-lib.mjs'
import { formatSolutionCode } from './solution-code-format.mjs'

const input = process.argv[2]
if (!input) throw new Error('用法：node scripts/import-content-batch.mjs <batch-module.mjs>')

const inputPath = resolve(input)
const batch = (await import(pathToFileURL(inputPath).href)).default
if (!batch || typeof batch.batchId !== 'string' || !Array.isArray(batch.problems) || batch.problems.length === 0) {
  throw new Error('批次模块必须默认导出 { batchId, problems }')
}

const catalog = await loadCatalog()
const catalogById = new Map(catalog.problems.map((problem) => [problem.id, problem]))
const seen = new Set()

for (const problem of batch.problems) {
  if (!Number.isInteger(problem.id) || seen.has(problem.id)) throw new Error(`批次题号无效或重复：${problem.id}`)
  seen.add(problem.id)
  const catalogProblem = catalogById.get(problem.id)
  if (!catalogProblem) throw new Error(`题号不在目录中：${problem.id}`)
  if (catalogProblem.slug !== problem.slug) throw new Error(`${problem.id} 的 slug 与目录不一致`)
  if (catalogProblem.paidOnly) throw new Error(`${problem.id} 是会员受限题，不能导入公开题解批次`)
  if (!Array.isArray(problem.solutions) || problem.solutions.length < 1 || problem.solutions.length > 3) {
    throw new Error(`${problem.id} 必须包含 1～3 种解法`)
  }
  if (!problem.tests || !Array.isArray(problem.tests.cases) || problem.tests.cases.length < 3) {
    throw new Error(`${problem.id} 至少需要 3 个行为测试`)
  }
  for (const solution of problem.solutions) {
    for (const language of ['java', 'kotlin', 'cpp']) {
      if (typeof solution.code?.[language] !== 'string' || !solution.code[language].trim()) {
        throw new Error(`${problem.id} / ${solution.id} 缺少 ${language} 代码`)
      }
    }
  }

  const directory = join(contentRoot, problemDirectoryName(problem.id, problem.slug))
  try {
    await access(join(directory, 'problem.json'))
    throw new Error(`目标题解已存在：${relative(projectRoot, directory)}`)
  } catch (error) {
    if (error.code !== 'ENOENT') throw error
  }
}

for (const problem of batch.problems) {
  const directory = join(contentRoot, problemDirectoryName(problem.id, problem.slug))
  const solutions = problem.solutions.map((solution) => ({
    id: solution.id,
    title: solution.title,
    kind: solution.kind,
    idea: solution.idea,
    steps: solution.steps,
    complexity: solution.complexity,
    files: {
      java: `solutions/${solution.id}/Solution.java`,
      kotlin: `solutions/${solution.id}/Solution.kt`,
      cpp: `solutions/${solution.id}/solution.cpp`,
    },
  }))
  const meta = {
    schemaVersion: 1,
    id: problem.id,
    slug: problem.slug,
    title: problem.title,
    status: 'published',
    qualityGate: 'tested',
    batch: batch.batchId,
    studyTags: problem.studyTags,
    summary: problem.summary,
    insight: problem.insight,
    pitfalls: problem.pitfalls,
    solutions,
  }

  await mkdir(directory, { recursive: true })
  await writeFile(join(directory, 'problem.json'), `${JSON.stringify(meta, null, 2)}\n`, { flag: 'wx' })
  await writeFile(join(directory, 'tests.json'), `${JSON.stringify(problem.tests, null, 2)}\n`, { flag: 'wx' })
  for (const solution of problem.solutions) {
    for (const [language, filename] of Object.entries({ java: 'Solution.java', kotlin: 'Solution.kt', cpp: 'solution.cpp' })) {
      const path = join(directory, 'solutions', solution.id, filename)
      await mkdir(dirname(path), { recursive: true })
      await writeFile(path, formatSolutionCode(solution.code[language], language), { flag: 'wx' })
    }
  }
}

console.log(`Imported batch ${batch.batchId}: ${batch.problems.length} problems.`)
