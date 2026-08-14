import { execFileSync } from 'node:child_process'
import { existsSync, mkdirSync, mkdtempSync, rmSync, writeFileSync } from 'node:fs'
import { tmpdir } from 'node:os'
import { join } from 'node:path'
import { loadProblemSources, projectRoot } from './content-lib.mjs'
import { createTestHarness } from './test-harness-lib.mjs'

const temp = mkdtempSync(join(tmpdir(), 'algorithm-atlas-behavior-'))
const kotlinCandidates = [
  '/home/SENSETIME/liuwei2.vendor/pkg/android-studio-2024.3.2.14-linux/android-studio/plugins/Kotlin/kotlinc/bin/kotlinc',
  '/home/SENSETIME/liuwei2.vendor/pkg/android-studio-2024.2.1.12-linux/android-studio/plugins/Kotlin/kotlinc/bin/kotlinc',
  '/home/SENSETIME/liuwei2.vendor/pkg/android-studio-2023.1.1.28-linux/android-studio/plugins/Kotlin/kotlinc/bin/kotlinc',
]
const kotlinc = kotlinCandidates.find(existsSync)

function run(binary, args, timeout = 20_000) {
  return execFileSync(binary, args, {
    cwd: projectRoot,
    encoding: 'utf8',
    stdio: ['ignore', 'pipe', 'pipe'],
    timeout,
  })
}

function safeName(value) {
  return value.replace(/[^a-zA-Z0-9_]/g, '_')
}

function argumentValue(name) {
  const index = process.argv.indexOf(name)
  return index >= 0 ? process.argv[index + 1] : undefined
}

const failures = []
const totals = { java: 0, kotlin: 0, cpp: 0 }
const kotlinCases = []

try {
  const { sources } = await loadProblemSources()
  const batch = argumentValue('--batch')
  const tested = sources.filter(
    (source) => source.meta.status === 'published' && source.tests.cases.length > 0 && (!batch || source.meta.batch === batch),
  )
  if (tested.length === 0) throw new Error(batch ? `批次不存在或没有行为测试：${batch}` : '没有可运行的行为测试')

  for (const source of tested) {
    for (const solution of source.problem.solutions) {
      const name = `${String(source.problem.id).padStart(4, '0')}-${safeName(solution.id)}`
      const caseDir = join(temp, name)
      mkdirSync(caseDir, { recursive: true })

      const javaFile = join(caseDir, 'AtlasTest.java')
      const javaOut = join(caseDir, 'java-out')
      mkdirSync(javaOut)
      writeFileSync(javaFile, createTestHarness('java', solution.code.java, source.tests))
      try {
        run('javac', ['-encoding', 'UTF-8', '-d', javaOut, javaFile])
        run('java', ['-cp', javaOut, 'AtlasTest'])
        totals.java++
      } catch (error) {
        failures.push({ name, language: 'java', output: error.stderr?.toString() || error.stdout?.toString() || error.message })
      }

      const cppFile = join(caseDir, 'atlas_test.cpp')
      const cppBinary = join(caseDir, 'atlas-test')
      writeFileSync(cppFile, createTestHarness('cpp', solution.code.cpp, source.tests))
      try {
        run('g++', ['-std=c++17', '-O2', cppFile, '-o', cppBinary])
        run(cppBinary, [])
        totals.cpp++
      } catch (error) {
        failures.push({ name, language: 'cpp', output: error.stderr?.toString() || error.stdout?.toString() || error.message })
      }

      if (kotlinc) {
        const packageName = `atlas.test.p${safeName(name)}`
        const kotlinFile = join(caseDir, 'AtlasTest.kt')
        writeFileSync(kotlinFile, createTestHarness('kotlin', solution.code.kotlin, source.tests, packageName))
        kotlinCases.push({ name, packageName, file: kotlinFile })
      }
    }
  }

  if (!kotlinc) {
    console.warn('Kotlin compiler not found; Kotlin behavior tests were not checked.')
  } else if (kotlinCases.length > 0) {
    const jar = join(temp, 'kotlin-tests.jar')
    try {
      run('bash', [kotlinc, ...kotlinCases.map((testCase) => testCase.file), '-include-runtime', '-d', jar], 180_000)
      for (const testCase of kotlinCases) {
        try {
          run('java', ['-cp', jar, `${testCase.packageName}.AtlasTestKt`])
          totals.kotlin++
        } catch (error) {
          failures.push({ name: testCase.name, language: 'kotlin', output: error.stderr?.toString() || error.stdout?.toString() || error.message })
        }
      }
    } catch (error) {
      failures.push({ name: 'Kotlin batch compilation', language: 'kotlin', output: error.stderr?.toString() || error.stdout?.toString() || error.message })
    }
  }

  if (failures.length > 0) {
    console.error(`Behavior validation failed: ${failures.length} error(s).`)
    for (const failure of failures) console.error(`\n[${failure.language}] ${failure.name}\n${failure.output.trim()}`)
    process.exitCode = 1
  } else {
    const implementations = totals.java + totals.kotlin + totals.cpp
    const cases = tested.reduce((sum, source) => sum + source.tests.cases.length * source.problem.solutions.length * 3, 0)
    console.log(
      `Passed ${cases} behavior assertions across ${implementations} implementations${batch ? ` in ${batch}` : ''}.`,
    )
  }
} finally {
  rmSync(temp, { recursive: true, force: true })
}
