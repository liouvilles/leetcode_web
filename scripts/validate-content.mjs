import { createManifest, loadProblemSources } from './content-lib.mjs'

const { catalog, sources } = await loadProblemSources()
const manifest = createManifest(sources)
const drafts = sources.filter((source) => source.meta.status !== 'published').length
const tested = sources.filter((source) => source.meta.qualityGate === 'tested').length
const compileOnly = sources.filter((source) => source.meta.qualityGate === 'compile').length
const paid = catalog.problems.filter((problem) => problem.paidOnly).length

console.log(
  `Validated ${sources.length} content directories: ${manifest.problemCount} published, ${drafts} draft/review, ` +
    `${tested} tested, ${compileOnly} compile-only, ${manifest.solutionCount} solutions. ` +
    `Catalog: ${catalog.problems.length} total, ${paid} restricted.`,
)
