import batch from './batch-014-h.mjs'

export default {
  ...batch,
  problems: batch.problems.filter((problem) => problem.id === 1005),
}
