import { access, readFile, readdir } from 'node:fs/promises'
import { join, relative, resolve, sep } from 'node:path'

export const projectRoot = resolve(import.meta.dirname, '..')
export const contentRoot = join(projectRoot, 'content', 'problems')
export const catalogPath = join(projectRoot, 'src', 'data', 'problem-catalog.json')
export const generatedRoot = join(projectRoot, 'src', 'generated')
export const generatedProblemRoot = join(generatedRoot, 'problems')

const languages = ['java', 'kotlin', 'cpp']
const kinds = new Set(['基础', '进阶', '最优'])
const statuses = new Set(['draft', 'review', 'published'])
const qualityGates = new Set(['compile', 'tested'])
const testTypes = new Set([
  'int',
  'long',
  'longArray',
  'double',
  'doubleArray',
  'boolean',
  'booleanArray',
  'string',
  'char',
  'charArray',
  'charMatrix',
  'intArray',
  'stringArray',
  'intMatrix',
  'intList',
  'longList',
  'booleanList',
  'doubleList',
  'stringList',
  'intListMatrix',
  'longListMatrix',
  'stringListMatrix',
  'listNode',
  'treeNode',
  'treeNodeList',
  'mountainArray',
  'customFunction',
])
const returnTypes = new Set([...testTypes, 'void'])

export function problemFileName(id) {
  return `${String(id).padStart(4, '0')}.json`
}

export function problemDirectoryName(id, slug) {
  return `${String(id).padStart(4, '0')}-${slug}`
}

async function readJson(path) {
  try {
    return JSON.parse(await readFile(path, 'utf8'))
  } catch (error) {
    throw new Error(`无法读取 JSON：${relative(projectRoot, path)}\n${error.message}`)
  }
}

function requireText(value, label) {
  if (typeof value !== 'string' || !value.trim()) throw new Error(`${label} 不能为空`)
}

function requireTextArray(value, label, minimum = 1) {
  if (!Array.isArray(value) || value.length < minimum || value.some((item) => typeof item !== 'string' || !item.trim())) {
    throw new Error(`${label} 必须至少包含 ${minimum} 个非空字符串`)
  }
}

function resolveContentFile(problemDir, file, label) {
  requireText(file, label)
  const target = resolve(problemDir, file)
  const prefix = `${resolve(problemDir)}${sep}`
  if (!target.startsWith(prefix)) throw new Error(`${label} 不能指向题目目录之外：${file}`)
  return target
}

export async function loadCatalog() {
  const catalog = await readJson(catalogPath)
  if (!catalog || !Array.isArray(catalog.problems)) throw new Error('题库目录缺少 problems 数组')
  return catalog
}

export async function loadProblemSources() {
  const catalog = await loadCatalog()
  const catalogById = new Map(catalog.problems.map((problem) => [problem.id, problem]))
  const directoryEntries = await readdir(contentRoot, { withFileTypes: true }).catch((error) => {
    if (error.code === 'ENOENT') return []
    throw error
  })
  const sources = []
  const seenIds = new Set()
  const seenSlugs = new Set()

  for (const entry of directoryEntries.filter((item) => item.isDirectory()).sort((a, b) => a.name.localeCompare(b.name))) {
    const problemDir = join(contentRoot, entry.name)
    const metaPath = join(problemDir, 'problem.json')
    const meta = await readJson(metaPath)
    const label = `${entry.name}/problem.json`

    if (meta.schemaVersion !== 1) throw new Error(`${label} 的 schemaVersion 必须为 1`)
    if (!Number.isInteger(meta.id) || meta.id <= 0) throw new Error(`${label} 的 id 无效`)
    requireText(meta.slug, `${label} / slug`)
    requireText(meta.title, `${label} / title`)
    requireText(meta.summary, `${label} / summary`)
    requireText(meta.insight, `${label} / insight`)
    requireTextArray(meta.studyTags, `${label} / studyTags`)
    requireTextArray(meta.pitfalls, `${label} / pitfalls`)
    if (!statuses.has(meta.status)) throw new Error(`${label} 的 status 必须是 draft、review 或 published`)
    if (!qualityGates.has(meta.qualityGate)) throw new Error(`${label} 的 qualityGate 必须是 compile 或 tested`)
    if (seenIds.has(meta.id)) throw new Error(`内容题号重复：${meta.id}`)
    if (seenSlugs.has(meta.slug)) throw new Error(`内容 slug 重复：${meta.slug}`)
    seenIds.add(meta.id)
    seenSlugs.add(meta.slug)

    const catalogProblem = catalogById.get(meta.id)
    if (!catalogProblem) throw new Error(`${label} 不在 3000 题目录中`)
    if (catalogProblem.slug !== meta.slug) {
      throw new Error(`${label} 的 slug 与题库目录不一致：${meta.slug} !== ${catalogProblem.slug}`)
    }
    if (catalogProblem.paidOnly && meta.status === 'published') {
      throw new Error(`${label} 是会员受限题，不能直接发布题解`)
    }
    if (entry.name !== problemDirectoryName(meta.id, meta.slug)) {
      throw new Error(`${label} 所在目录应命名为 ${problemDirectoryName(meta.id, meta.slug)}`)
    }
    if (!Array.isArray(meta.solutions) || meta.solutions.length < 1 || meta.solutions.length > 3) {
      throw new Error(`${label} 必须包含 1～3 种解法`)
    }

    const solutionIds = new Set()
    const solutions = []
    for (const solution of meta.solutions) {
      const solutionLabel = `${label} / ${solution?.id ?? 'unknown'}`
      requireText(solution.id, `${solutionLabel} / id`)
      requireText(solution.title, `${solutionLabel} / title`)
      requireText(solution.idea, `${solutionLabel} / idea`)
      requireTextArray(solution.steps, `${solutionLabel} / steps`)
      requireText(solution.complexity?.time, `${solutionLabel} / complexity.time`)
      requireText(solution.complexity?.space, `${solutionLabel} / complexity.space`)
      if (!kinds.has(solution.kind)) throw new Error(`${solutionLabel} 的 kind 无效`)
      if (solutionIds.has(solution.id)) throw new Error(`${label} 的解法 ID 重复：${solution.id}`)
      solutionIds.add(solution.id)

      const code = {}
      for (const language of languages) {
        const path = resolveContentFile(problemDir, solution.files?.[language], `${solutionLabel} / files.${language}`)
        await access(path)
        code[language] = await readFile(path, 'utf8')
        requireText(code[language], `${solutionLabel} / ${language} 代码`)
        if (code[language].trim().split(/\r?\n/).length < 2) {
          throw new Error(`${solutionLabel} / ${language} 代码必须使用多行格式，不能整段压在一行`)
        }
      }
      solutions.push({
        id: solution.id,
        title: solution.title,
        kind: solution.kind,
        idea: solution.idea,
        steps: solution.steps,
        complexity: solution.complexity,
        code,
      })
    }

    const testsPath = join(problemDir, 'tests.json')
    const tests = await readJson(testsPath)
    if (tests.schemaVersion !== 1 || !Array.isArray(tests.cases)) {
      throw new Error(`${entry.name}/tests.json 必须包含 schemaVersion: 1 和 cases 数组`)
    }
    if (meta.qualityGate === 'tested' && tests.cases.length < 3) {
      throw new Error(`${entry.name}/tests.json 至少需要 3 个行为测试才能通过 tested 门禁`)
    }
    if (tests.cases.length > 0 && tests.mode === 'function') {
      requireText(tests.method, `${entry.name}/tests.json / method`)
      if (!/^[A-Za-z_$][\w$]*$/.test(tests.method)) throw new Error(`${entry.name}/tests.json / method 无效`)
      if (!Array.isArray(tests.parameterTypes) || tests.parameterTypes.some((type) => !testTypes.has(type))) {
        throw new Error(`${entry.name}/tests.json / parameterTypes 包含不支持的类型`)
      }
      if (!returnTypes.has(tests.returnType)) throw new Error(`${entry.name}/tests.json / returnType 不受支持`)
      for (const [index, testCase] of tests.cases.entries()) {
        requireText(testCase?.name, `${entry.name}/tests.json / cases[${index}].name`)
        if (!Array.isArray(testCase?.args) || testCase.args.length !== tests.parameterTypes.length) {
          throw new Error(`${entry.name}/tests.json / cases[${index}].args 数量与 parameterTypes 不一致`)
        }
        if (tests.returnType !== 'void' && !Object.hasOwn(testCase, 'expected')) {
          throw new Error(`${entry.name}/tests.json / cases[${index}] 缺少 expected`)
        }
        if (tests.returnType === 'void' && (!Array.isArray(testCase.expectedArgs) || testCase.expectedArgs.length === 0)) {
          throw new Error(`${entry.name}/tests.json / cases[${index}] 的 void 方法需要 expectedArgs`)
        }
        for (const [expectedIndex, expectedArg] of (testCase.expectedArgs ?? []).entries()) {
          const expectedLabel = `${entry.name}/tests.json / cases[${index}].expectedArgs[${expectedIndex}]`
          if (!Number.isInteger(expectedArg?.index) || expectedArg.index < 0 || expectedArg.index >= tests.parameterTypes.length) {
            throw new Error(`${expectedLabel}.index 无效`)
          }
          if (expectedArg.type !== tests.parameterTypes[expectedArg.index]) {
            throw new Error(`${expectedLabel}.type 必须与 parameterTypes 对应项一致`)
          }
          if (!Object.hasOwn(expectedArg, 'expected')) throw new Error(`${expectedLabel} 缺少 expected`)
        }
      }
    } else if (tests.cases.length > 0 && tests.mode === 'design') {
      requireText(tests.className, `${entry.name}/tests.json / className`)
      if (!/^[A-Za-z_$][\w$]*$/.test(tests.className)) throw new Error(`${entry.name}/tests.json / className 无效`)
      if (!Array.isArray(tests.constructorTypes) || tests.constructorTypes.some((type) => !testTypes.has(type))) {
        throw new Error(`${entry.name}/tests.json / constructorTypes 包含不支持的类型`)
      }
      for (const [index, testCase] of tests.cases.entries()) {
        requireText(testCase?.name, `${entry.name}/tests.json / cases[${index}].name`)
        if (!Array.isArray(testCase?.constructorArgs) || testCase.constructorArgs.length !== tests.constructorTypes.length) {
          throw new Error(`${entry.name}/tests.json / cases[${index}].constructorArgs 数量不一致`)
        }
        if (!Array.isArray(testCase?.calls) || testCase.calls.length === 0) {
          throw new Error(`${entry.name}/tests.json / cases[${index}].calls 不能为空`)
        }
        for (const [callIndex, call] of testCase.calls.entries()) {
          const callLabel = `${entry.name}/tests.json / cases[${index}].calls[${callIndex}]`
          requireText(call?.method, `${callLabel}.method`)
          if (!Array.isArray(call?.parameterTypes) || call.parameterTypes.some((type) => !testTypes.has(type))) {
            throw new Error(`${callLabel}.parameterTypes 包含不支持的类型`)
          }
          if (!Array.isArray(call?.args) || call.args.length !== call.parameterTypes.length) {
            throw new Error(`${callLabel}.args 数量与 parameterTypes 不一致`)
          }
          if (Object.hasOwn(call, 'expected') && !testTypes.has(call.returnType)) {
            throw new Error(`${callLabel}.returnType 不受支持`)
          }
        }
      }
    } else if (tests.cases.length > 0) {
      throw new Error(`${entry.name}/tests.json 的 mode 必须是 function 或 design`)
    }

    sources.push({
      directory: problemDir,
      meta,
      tests,
      problem: {
        ...catalogProblem,
        title: meta.title,
        studyTags: meta.studyTags,
        summary: meta.summary,
        insight: meta.insight,
        pitfalls: meta.pitfalls,
        solutions,
      },
    })
  }

  return { catalog, sources }
}

export function createManifest(sources) {
  const published = sources.filter((source) => source.meta.status === 'published')
  const problems = published.map(({ meta, problem, tests }) => ({
    id: problem.id,
    slug: problem.slug,
    title: problem.title,
    studyTags: problem.studyTags,
    status: meta.status,
    batch: meta.batch,
    solutionCount: problem.solutions.length,
    testCount: tests.cases.length,
    qualityGate: meta.qualityGate,
  }))
  const solutionCount = problems.reduce((sum, problem) => sum + problem.solutionCount, 0)
  return {
    schemaVersion: 1,
    problemCount: problems.length,
    solutionCount,
    implementationCount: solutionCount * languages.length,
    problems,
  }
}
