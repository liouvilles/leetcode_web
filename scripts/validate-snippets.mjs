import { execFileSync } from 'node:child_process'
import { existsSync, mkdirSync, mkdtempSync, readFileSync, rmSync, writeFileSync } from 'node:fs'
import { tmpdir } from 'node:os'
import { join } from 'node:path'
import { loadProblemSources, projectRoot } from './content-lib.mjs'

const root = projectRoot
const temp = mkdtempSync(join(tmpdir(), 'algorithm-atlas-snippets-'))
const kotlinCandidates = [
  '/home/SENSETIME/liuwei2.vendor/pkg/android-studio-2024.3.2.14-linux/android-studio/plugins/Kotlin/kotlinc/bin/kotlinc',
  '/home/SENSETIME/liuwei2.vendor/pkg/android-studio-2024.2.1.12-linux/android-studio/plugins/Kotlin/kotlinc/bin/kotlinc',
  '/home/SENSETIME/liuwei2.vendor/pkg/android-studio-2023.1.1.28-linux/android-studio/plugins/Kotlin/kotlinc/bin/kotlinc',
]
const kotlinc = kotlinCandidates.find(existsSync)

const javaPrefix = `import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
class MountainArray {
    private final int[] data;
    MountainArray(int[] data) { this.data = data; }
    public int get(int index) { return data[index]; }
    public int length() { return data.length; }
}
class CustomFunction {
    public int f(int x, int y) { return x + y; }
}
`

const kotlinPrefix = `import java.util.*
class ListNode(var \`val\`: Int) { var next: ListNode? = null }
class TreeNode(var \`val\`: Int) { var left: TreeNode? = null; var right: TreeNode? = null }
class MountainArray(private val data: IntArray) { fun get(index: Int): Int = data[index]; fun length(): Int = data.size }
class CustomFunction { fun f(x: Int, y: Int): Int = x + y }
`

const cppPrefix = `#include <bits/stdc++.h>
using namespace std;
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int value = 0, ListNode* nextNode = nullptr) : val(value), next(nextNode) {}
};
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int value = 0) : val(value), left(nullptr), right(nullptr) {}
};
class MountainArray {
    vector<int> data;
public:
    MountainArray(vector<int> values) : data(move(values)) {}
    int get(int index) { return data[index]; }
    int length() { return data.size(); }
};
class CustomFunction {
public:
    int f(int x, int y) { return x + y; }
};
`

function run(binary, args) {
  return execFileSync(binary, args, {
    cwd: root,
    encoding: 'utf8',
    stdio: ['ignore', 'pipe', 'pipe'],
  })
}

function safeName(value) {
  return value.replace(/[^a-zA-Z0-9_-]/g, '-')
}

function argumentValue(name) {
  const index = process.argv.indexOf(name)
  return index >= 0 ? process.argv[index + 1] : undefined
}

try {
  const { sources } = await loadProblemSources()
  const batch = argumentValue('--batch')
  const problems = sources
    .filter((source) => source.meta.status === 'published' && (!batch || source.meta.batch === batch))
    .map((source) => source.problem)
  if (problems.length === 0) throw new Error(batch ? `批次不存在或没有已发布内容：${batch}` : '没有已发布题解')
  const failures = []
  const totals = { java: 0, kotlin: 0, cpp: 0 }
  const kotlinFiles = []

  for (const problem of problems) {
    for (const solution of problem.solutions) {
      const name = `${String(problem.id).padStart(4, '0')}-${safeName(solution.id)}`
      const caseDir = join(temp, name)
      mkdirSync(caseDir, { recursive: true })

      const cases = [
        {
          language: 'java',
          available: true,
          file: join(caseDir, 'Solution.java'),
          source: javaPrefix + solution.code.java,
          binary: 'javac',
          args: ['-encoding', 'UTF-8', '-d', join(caseDir, 'java-out'), join(caseDir, 'Solution.java')],
        },
        {
          language: 'kotlin',
          available: Boolean(kotlinc),
          file: join(caseDir, 'Solution.kt'),
          source: `package atlas.p${name.replaceAll('-', '_')}\n` + kotlinPrefix + solution.code.kotlin,
          binary: 'bash',
          args: [],
        },
        {
          language: 'cpp',
          available: true,
          file: join(caseDir, 'solution.cpp'),
          source: cppPrefix + solution.code.cpp + '\nint main() { return 0; }\n',
          binary: 'g++',
          args: ['-std=c++17', '-fsyntax-only', join(caseDir, 'solution.cpp')],
        },
      ]

      for (const testCase of cases) {
        if (!testCase.available) continue
        writeFileSync(testCase.file, testCase.source)
        if (testCase.language === 'kotlin') {
          kotlinFiles.push(testCase.file)
          continue
        }
        if (testCase.language === 'java') mkdirSync(join(caseDir, 'java-out'))
        try {
          run(testCase.binary, testCase.args)
          totals[testCase.language]++
        } catch (error) {
          failures.push({
            problem: `${problem.id}. ${problem.title}`,
            solution: solution.title,
            language: testCase.language,
            output: error.stderr?.toString() || error.stdout?.toString() || error.message,
            source: readFileSync(testCase.file, 'utf8'),
          })
        }
      }
    }
  }

  if (!kotlinc) {
    console.warn('Kotlin compiler not found; Kotlin snippets were not checked.')
  } else {
    try {
      run('bash', [kotlinc, ...kotlinFiles, '-d', join(temp, 'kotlin-snippets.jar')])
      totals.kotlin = kotlinFiles.length
    } catch (error) {
      failures.push({
        problem: 'Kotlin batch',
        solution: `${kotlinFiles.length} snippets`,
        language: 'kotlin',
        output: error.stderr?.toString() || error.stdout?.toString() || error.message,
      })
    }
  }

  if (failures.length) {
    console.error(`Snippet validation failed: ${failures.length} error(s).`)
    for (const failure of failures) {
      console.error(`\n[${failure.language}] ${failure.problem} / ${failure.solution}`)
      console.error(failure.output.trim())
    }
    process.exitCode = 1
  } else {
    const total = totals.java + totals.kotlin + totals.cpp
    console.log(
      `Validated ${total} snippets${batch ? ` in ${batch}` : ''}: ` +
        `Java ${totals.java}, Kotlin ${totals.kotlin}, C++ ${totals.cpp}.`,
    )
  }
} finally {
  rmSync(temp, { recursive: true, force: true })
}
