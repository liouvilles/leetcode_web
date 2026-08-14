import { execFileSync } from 'node:child_process'
import { mkdir, mkdtemp, readFile, rm, writeFile } from 'node:fs/promises'
import { tmpdir } from 'node:os'
import { join, relative } from 'node:path'
import { pathToFileURL } from 'node:url'
import { contentRoot, problemDirectoryName, projectRoot } from './content-lib.mjs'

const temp = await mkdtemp(join(tmpdir(), 'algorithm-atlas-migration-'))
const bundle = join(temp, 'catalog.mjs')
const esbuild = join(projectRoot, 'node_modules', '.bin', 'esbuild')
const source = join(projectRoot, 'scripts', 'catalog-export.ts')

function solutionFiles(solutionId) {
  const root = `solutions/${solutionId}`
  return {
    java: `${root}/Solution.java`,
    kotlin: `${root}/Solution.kt`,
    cpp: `${root}/solution.cpp`,
  }
}

try {
  execFileSync(esbuild, [source, '--bundle', '--platform=node', '--format=esm', `--outfile=${bundle}`], {
    cwd: projectRoot,
    stdio: 'inherit',
  })
  const { problems } = await import(pathToFileURL(bundle).href)

  for (const problem of problems) {
    const directory = join(contentRoot, problemDirectoryName(problem.id, problem.slug))
    const metaPath = join(directory, 'problem.json')
    try {
      await readFile(metaPath, 'utf8')
      throw new Error(`目标已存在，停止迁移以避免覆盖：${relative(projectRoot, metaPath)}`)
    } catch (error) {
      if (error.code !== 'ENOENT') throw error
    }

    const meta = {
      schemaVersion: 1,
      id: problem.id,
      slug: problem.slug,
      title: problem.title,
      status: 'published',
      qualityGate: 'compile',
      batch: 'legacy-001',
      studyTags: problem.studyTags,
      summary: problem.summary,
      insight: problem.insight,
      pitfalls: problem.pitfalls,
      solutions: problem.solutions.map((solution) => ({
        id: solution.id,
        title: solution.title,
        kind: solution.kind,
        idea: solution.idea,
        steps: solution.steps,
        complexity: solution.complexity,
        files: solutionFiles(solution.id),
      })),
    }

    await mkdir(directory, { recursive: true })
    await writeFile(metaPath, `${JSON.stringify(meta, null, 2)}\n`)
    await writeFile(join(directory, 'tests.json'), `${JSON.stringify({ schemaVersion: 1, cases: [] }, null, 2)}\n`)
    for (const solution of problem.solutions) {
      const files = solutionFiles(solution.id)
      for (const [language, file] of Object.entries(files)) {
        const path = join(directory, file)
        await mkdir(join(directory, 'solutions', solution.id), { recursive: true })
        await writeFile(path, `${solution.code[language].trim()}\n`)
      }
    }
  }

  console.log(`Migrated ${problems.length} detailed problems into content/problems.`)
} finally {
  await rm(temp, { recursive: true, force: true })
}
