import { arrayProblems } from '../src/data/problems-arrays'
import { dpGraphProblems } from '../src/data/problems-dp-graph'
import { linkedProblems } from '../src/data/problems-linked'
import { treeProblems } from '../src/data/problems-trees'

export const problems = [
  ...arrayProblems,
  ...linkedProblems,
  ...treeProblems,
  ...dpGraphProblems,
].sort((a, b) => a.id - b.id)
