import { mkdir, readdir, rm, writeFile } from 'node:fs/promises'
import { join } from 'node:path'
import {
  createManifest,
  generatedProblemRoot,
  generatedRoot,
  loadProblemSources,
  problemFileName,
} from './content-lib.mjs'

const { sources } = await loadProblemSources()
const published = sources.filter((source) => source.meta.status === 'published')

await mkdir(generatedProblemRoot, { recursive: true })
for (const entry of await readdir(generatedProblemRoot, { withFileTypes: true })) {
  if (entry.isFile() && entry.name.endsWith('.json')) {
    await rm(join(generatedProblemRoot, entry.name))
  }
}

for (const source of published) {
  await writeFile(
    join(generatedProblemRoot, problemFileName(source.problem.id)),
    `${JSON.stringify(source.problem)}\n`,
  )
}

const manifest = createManifest(sources)
await mkdir(generatedRoot, { recursive: true })
await writeFile(join(generatedRoot, 'problem-manifest.json'), `${JSON.stringify(manifest, null, 2)}\n`)
console.log(
  `Generated ${manifest.problemCount} problem details, ${manifest.solutionCount} solutions, ` +
    `${manifest.implementationCount} implementations.`,
)
