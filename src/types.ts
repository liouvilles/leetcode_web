export type Difficulty = '简单' | '中等' | '困难'
export type Language = 'java' | 'kotlin' | 'cpp'
export type SolutionKind = '基础' | '进阶' | '最优'

export interface Complexity {
  time: string
  space: string
}

export interface CodeSet {
  java: string
  kotlin: string
  cpp: string
}

export interface Solution {
  id: string
  title: string
  kind: SolutionKind
  idea: string
  steps: string[]
  complexity: Complexity
  code: CodeSet
}

export interface CatalogProblem {
  id: number
  slug: string
  title: string
  titleEn: string
  difficulty: Difficulty
  category: string
  officialTags: string[]
  studyTags: string[]
  paidOnly?: boolean
  sourceUrl: string
}

export interface Problem extends CatalogProblem {
  summary: string
  insight: string
  pitfalls: string[]
  solutions: Solution[]
}
