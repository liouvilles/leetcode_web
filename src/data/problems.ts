import type { CatalogProblem, Difficulty, Problem } from '../types'
import manifest from '../generated/problem-manifest.json'
import catalog from './problem-catalog.json'

interface CatalogEntry {
  id: number
  slug: string
  titleEn: string
  difficulty: Difficulty
  category: string
  officialTags: string[]
  paidOnly: boolean
  sourceUrl: string
}

interface CatalogSource {
  repository: string
  commit: string
  commitDate: string
  license: string
  importedFields: string[]
}

interface ContentManifestEntry {
  id: number
  slug: string
  title: string
  studyTags: string[]
  status: 'published'
  batch: string
  solutionCount: number
  testCount: number
  qualityGate: 'compile' | 'tested'
}

interface ContentManifest {
  schemaVersion: number
  problemCount: number
  solutionCount: number
  implementationCount: number
  problems: ContentManifestEntry[]
}

const contentManifest = manifest as ContentManifest
const detailLoaders = import.meta.glob<{ default: Problem }>('../generated/problems/*.json')

function validateCatalog(entries: CatalogEntry[], contentEntries: ContentManifestEntry[]) {
  if (entries.length === 0 || entries.length > 3000) {
    throw new Error(`题库规模必须在 1 到 3000 之间，当前为 ${entries.length}`)
  }

  const ids = new Set<number>()
  const slugs = new Set<string>()
  const catalogById = new Map<number, CatalogEntry>()
  for (const entry of entries) {
    if (ids.has(entry.id)) throw new Error(`题库编号重复：${entry.id}`)
    if (slugs.has(entry.slug)) throw new Error(`题库 slug 重复：${entry.slug}`)
    ids.add(entry.id)
    slugs.add(entry.slug)
    catalogById.set(entry.id, entry)
  }

  const contentIds = new Set<number>()
  for (const entry of contentEntries) {
    const catalogEntry = catalogById.get(entry.id)
    if (!catalogEntry) throw new Error(`题解不在 3000 题索引中：${entry.id}. ${entry.title}`)
    if (catalogEntry.slug !== entry.slug) throw new Error(`题解 slug 与索引不一致：${entry.id}. ${entry.slug}`)
    if (catalogEntry.paidOnly) throw new Error(`会员受限题不能直接发布：${entry.id}. ${entry.title}`)
    if (contentIds.has(entry.id)) throw new Error(`题解清单编号重复：${entry.id}`)
    if (entry.solutionCount < 1 || entry.solutionCount > 3) {
      throw new Error(`${entry.title} 的解法数量必须在 1 到 3 之间`)
    }
    contentIds.add(entry.id)
  }

  if (contentManifest.problemCount !== contentEntries.length) throw new Error('题解清单 problemCount 不一致')
  if (contentManifest.solutionCount !== contentEntries.reduce((sum, entry) => sum + entry.solutionCount, 0)) {
    throw new Error('题解清单 solutionCount 不一致')
  }
}

validateCatalog(catalog.problems as CatalogEntry[], contentManifest.problems)

const contentById = new Map(contentManifest.problems.map((entry) => [entry.id, entry]))

export const problems: CatalogProblem[] = (catalog.problems as CatalogEntry[]).map((entry) => {
  const content = contentById.get(entry.id)
  return {
    ...entry,
    title: content?.title ?? entry.titleEn,
    studyTags: content?.studyTags ?? [],
  }
})

export function hasProblemDetail(problem: CatalogProblem | number) {
  const id = typeof problem === 'number' ? problem : problem.id
  return contentById.has(id)
}

export function getSolutionCount(problem: CatalogProblem | number) {
  const id = typeof problem === 'number' ? problem : problem.id
  return contentById.get(id)?.solutionCount ?? 0
}

export async function loadProblemDetail(problem: CatalogProblem | number): Promise<Problem> {
  const id = typeof problem === 'number' ? problem : problem.id
  if (!contentById.has(id)) throw new Error(`第 ${id} 题尚未发布题解`)
  const key = `../generated/problems/${String(id).padStart(4, '0')}.json`
  const loader = detailLoaders[key]
  if (!loader) throw new Error(`第 ${id} 题的详情文件不存在`)
  const loaded = (await loader()).default
  if (loaded.id !== id) throw new Error(`第 ${id} 题的详情文件编号不匹配`)
  return loaded
}

const categoryCounts = new Map<string, number>()
for (const problem of problems) {
  categoryCounts.set(problem.category, (categoryCounts.get(problem.category) ?? 0) + 1)
}

export const categories = [...categoryCounts.keys()].sort(
  (a, b) => (categoryCounts.get(b) ?? 0) - (categoryCounts.get(a) ?? 0) || a.localeCompare(b, 'zh-CN'),
)
export const catalogSource = catalog.source as CatalogSource
export const officialTags = [...new Set(problems.flatMap((problem) => problem.officialTags))]
export const studyTags = [...new Set(contentManifest.problems.flatMap((problem) => problem.studyTags))]
export const detailedProblemCount = contentManifest.problemCount
export const solutionCount = contentManifest.solutionCount
export const implementationCount = contentManifest.implementationCount
export const testedProblemCount = contentManifest.problems.filter((problem) => problem.qualityGate === 'tested').length
export const restrictedProblemCount = problems.filter((problem) => problem.paidOnly).length
export const pendingProblemCount = problems.length - detailedProblemCount - restrictedProblemCount
