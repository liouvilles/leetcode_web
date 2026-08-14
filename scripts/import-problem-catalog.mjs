import { readFile, writeFile } from 'node:fs/promises'
import { resolve } from 'node:path'

const MAX_PROBLEMS = 3000
const SOURCE_COMMIT = 'd15584db2519967922e407fbb947aeec085ca702'
const SOURCE_COMMIT_DATE = '2026-08-13T02:17:24Z'
const SOURCE_REPOSITORY = 'https://github.com/noworneverev/leetcode-api'
const SOURCE_URL = `https://raw.githubusercontent.com/noworneverev/leetcode-api/${SOURCE_COMMIT}/data/leetcode_questions.json`
const outputPath = resolve(import.meta.dirname, '../src/data/problem-catalog.json')

const difficultyMap = {
  Easy: '简单',
  Medium: '中等',
  Hard: '困难',
}

const tagTranslations = {
  Array: '数组',
  'Hash Table': '哈希表',
  'Linked List': '链表',
  Math: '数学',
  Recursion: '递归',
  String: '字符串',
  'Sliding Window': '滑动窗口',
  'Two Pointers': '双指针',
  'Binary Search': '二分查找',
  'Divide and Conquer': '分治',
  'Dynamic Programming': '动态规划',
  Memoization: '记忆化搜索',
  Backtracking: '回溯',
  Greedy: '贪心',
  Sorting: '排序',
  Sort: '排序',
  'Merge Sort': '归并排序',
  Quicksort: '快速排序',
  'Counting Sort': '计数排序',
  'Bucket Sort': '桶排序',
  'Radix Sort': '基数排序',
  Quickselect: '快速选择',
  Stack: '栈',
  Queue: '队列',
  'Monotonic Stack': '单调栈',
  'Monotonic Queue': '单调队列',
  'Heap (Priority Queue)': '堆（优先队列）',
  Tree: '树',
  'Binary Tree': '二叉树',
  'Binary Search Tree': '二叉搜索树',
  Trie: '字典树',
  'Depth-First Search': '深度优先搜索',
  'Breadth-First Search': '广度优先搜索',
  'Bidirectional Search': '双向搜索',
  'A* Search': 'A* 搜索',
  Graph: '图',
  'Graph Theory': '图论',
  'Topological Sort': '拓扑排序',
  'Shortest Path': '最短路',
  'Minimum Spanning Tree': '最小生成树',
  'Union-Find': '并查集',
  'Strongly Connected Component': '强连通分量',
  'Bipartite Graph': '二分图',
  Matrix: '矩阵',
  Simulation: '模拟',
  Enumeration: '枚举',
  Counting: '计数',
  'Prefix Sum': '前缀和',
  'Difference Array': '差分数组',
  'Bit Manipulation': '位运算',
  Bitmask: '状态压缩',
  Combinatorics: '组合数学',
  'Number Theory': '数论',
  Geometry: '几何',
  'Game Theory': '博弈论',
  Probability: '概率',
  'Probability and Statistics': '概率与统计',
  Randomized: '随机化',
  Design: '设计',
  'Data Stream': '数据流',
  Iterator: '迭代器',
  Interactive: '交互',
  'Segment Tree': '线段树',
  'Binary Indexed Tree': '树状数组',
  'Sparse Table': '稀疏表',
  'Ordered Set': '有序集合',
  'Doubly-Linked List': '双向链表',
  'String Matching': '字符串匹配',
  'Rolling Hash': '滚动哈希',
  'Suffix Array': '后缀数组',
  'Sweep Line': '扫描线',
  'Meet in the Middle': '折半搜索',
  'Brute-Force Search': '暴力搜索',
  'Knapsack Problem': '背包问题',
  '0-1 Knapsack': '0-1 背包',
  'Complete Knapsack': '完全背包',
  'Multiple Knapsack': '多重背包',
  'DP on Trees': '树形 DP',
  'Longest Common Subsequence': '最长公共子序列',
  'Longest Increasing Subsequence': '最长递增子序列',
}

const categoryRules = [
  ['动态规划', ['Dynamic Programming', 'Memoization', 'Knapsack Problem', '0-1 Knapsack', 'Complete Knapsack', 'Multiple Knapsack', 'Mixed Knapsack', 'DP on Trees', 'Longest Common Subsequence', 'Longest Increasing Subsequence']],
  ['图论', ['Graph Theory', 'Bipartite Graph', 'Topological Sort', 'Shortest Path', 'Dijkstra\'s Algorithm', 'Bellman–Ford Algorithm', 'Floyd–Warshall Algorithm', 'Minimum Spanning Tree', 'Union-Find', 'Strongly Connected Component', 'Flow Network', 'Maximum Flow', 'Matching (Graph)']],
  ['树与高级结构', ['Tree', 'Binary Tree', 'Binary Search Tree', 'Trie', 'Segment Tree', 'Binary Indexed Tree', 'Sparse Table', 'Treap', 'Splay Tree', 'Suffix Tree', 'Palindromic Tree']],
  ['链表', ['Linked List', 'Doubly-Linked List']],
  ['字符串', ['String', 'String Matching', 'Rolling Hash', 'Suffix Array', 'Suffix Automaton', 'Aho–Corasick Algorithm', 'Knuth–Morris–Pratt Algorithm', 'Manacher', 'Z Algorithm']],
  ['搜索与回溯', ['Backtracking', 'Breadth-First Search', 'Depth-First Search', 'Bidirectional Search', 'A* Search', 'Brute-Force Search', 'Recursion']],
  ['数据结构与设计', ['Design', 'Data Stream', 'Iterator', 'Heap (Priority Queue)', 'Stack', 'Queue', 'Monotonic Stack', 'Monotonic Queue', 'Ordered Set', 'Persistent Data Structure']],
  ['数组与矩阵', ['Array', 'Matrix', 'Prefix Sum', 'Sliding Window', 'Two Pointers']],
  ['排序与选择', ['Sorting', 'Sort', 'Merge Sort', 'Quicksort', 'Quickselect', 'Counting Sort', 'Bucket Sort', 'Radix Sort']],
  ['数学', ['Math', 'Number Theory', 'Combinatorics', 'Greatest Common Divisor', 'Geometry', 'Linear Algebra']],
  ['贪心', ['Greedy']],
  ['位运算', ['Bit Manipulation', 'Bitmask']],
  ['概率与随机', ['Probability and Statistics', 'Randomized', 'Reservoir Sampling', 'Rejection Sampling']],
  ['模拟与枚举', ['Simulation', 'Enumeration', 'Counting']],
]

function classify(tags) {
  for (const [category, candidates] of categoryRules) {
    if (candidates.some((candidate) => tags.includes(candidate))) return category
  }
  return '综合算法'
}

function getSlug(url) {
  const match = url?.match(/\/problems\/([^/]+)\/?/)
  if (!match) throw new Error(`无法从 URL 解析 slug：${url}`)
  return match[1]
}

async function loadSource() {
  const inputPath = process.argv[2]
  if (inputPath) return JSON.parse(await readFile(resolve(inputPath), 'utf8'))

  const response = await fetch(SOURCE_URL)
  if (!response.ok) throw new Error(`下载题库元数据失败：HTTP ${response.status}`)
  return response.json()
}

const source = await loadSource()
const seenIds = new Set()
const problems = source
  .map((entry) => entry?.data?.question)
  .filter((question) => question?.categoryTitle === 'Algorithms')
  .filter((question) => /^\d+$/.test(question.questionFrontendId))
  .sort((a, b) => Number(a.questionFrontendId) - Number(b.questionFrontendId))
  .filter((question) => {
    const id = Number(question.questionFrontendId)
    if (seenIds.has(id)) return false
    seenIds.add(id)
    return true
  })
  .slice(0, MAX_PROBLEMS)
  .map((question) => {
    const slug = getSlug(question.url)
    const rawTags = (question.topicTags ?? []).map((tag) => tag.name).filter(Boolean)
    return {
      id: Number(question.questionFrontendId),
      slug,
      titleEn: question.title,
      difficulty: difficultyMap[question.difficulty],
      category: classify(rawTags),
      officialTags: rawTags.map((tag) => tagTranslations[tag] ?? tag),
      paidOnly: Boolean(question.isPaidOnly),
      sourceUrl: `https://leetcode.cn/problems/${slug}/`,
    }
  })

if (problems.length !== MAX_PROBLEMS) {
  throw new Error(`期望生成 ${MAX_PROBLEMS} 道题，实际只有 ${problems.length} 道`)
}

const catalog = {
  source: {
    repository: SOURCE_REPOSITORY,
    commit: SOURCE_COMMIT,
    commitDate: SOURCE_COMMIT_DATE,
    license: 'MIT',
    importedFields: ['id', 'titleEn', 'difficulty', 'officialTags', 'paidOnly', 'sourceUrl'],
  },
  count: problems.length,
  problems,
}

await writeFile(outputPath, `${JSON.stringify(catalog)}\n`)
console.log(`已生成 ${problems.length} 道题：${outputPath}`)
