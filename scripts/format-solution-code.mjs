import { readFile, readdir, writeFile } from 'node:fs/promises'
import { basename, join, relative } from 'node:path'
import { contentRoot, projectRoot } from './content-lib.mjs'
import { formatSolutionCode, isSingleLineSolutionCode } from './solution-code-format.mjs'

const solutionFileNames = new Set(['Solution.java', 'Solution.kt', 'solution.cpp'])
const write = process.argv.includes('--write')

function languageFor(file) {
  if (file.endsWith('.java')) return 'java'
  if (file.endsWith('.kt')) return 'kotlin'
  return 'cpp'
}

async function collectSolutionFiles(directory, files = []) {
  for (const entry of await readdir(directory, { withFileTypes: true })) {
    const path = join(directory, entry.name)
    if (entry.isDirectory()) await collectSolutionFiles(path, files)
    else if (entry.isFile() && solutionFileNames.has(basename(path))) files.push(path)
  }
  return files
}

const files = (await collectSolutionFiles(contentRoot)).sort()
const unformatted = []

for (const file of files) {
  const source = await readFile(file, 'utf8')
  if (!isSingleLineSolutionCode(source)) continue
  unformatted.push(file)
  if (write) await writeFile(file, formatSolutionCode(source, languageFor(file)))
}

if (unformatted.length === 0) {
  console.log(`Checked ${files.length} solution files: all use multiline formatting.`)
} else if (write) {
  console.log(`Formatted ${unformatted.length} single-line solution files.`)
} else {
  console.error(`Found ${unformatted.length} single-line solution files:`)
  for (const file of unformatted.slice(0, 20)) console.error(`- ${relative(projectRoot, file)}`)
  if (unformatted.length > 20) console.error(`- ... and ${unformatted.length - 20} more`)
  process.exitCode = 1
}
