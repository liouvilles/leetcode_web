import { useEffect, useMemo, useState } from 'react'
import {
  catalogSource,
  categories,
  detailedProblemCount,
  getSolutionCount,
  hasProblemDetail,
  implementationCount,
  loadProblemDetail,
  pendingProblemCount,
  problems,
  restrictedProblemCount,
  solutionCount,
} from './data/problems'
import type { CatalogProblem, Difficulty, Language, Problem } from './types'

type ProgressFilter = '全部' | '未开始' | '已掌握'
type ContentFilter = '全部内容' | '已有题解' | '待补充' | '会员受限'
type SortMode = '题号' | '难度' | '解法数'
type Theme = 'light' | 'dark'

const PAGE_SIZE = 50

const languageLabels: Record<Language, string> = {
  java: 'Java',
  kotlin: 'Kotlin',
  cpp: 'C++',
}

const difficultyOrder: Record<Difficulty, number> = {
  简单: 0,
  中等: 1,
  困难: 2,
}

function readNumberSet(key: string) {
  try {
    const value = JSON.parse(localStorage.getItem(key) ?? '[]')
    return new Set<number>(Array.isArray(value) ? value : [])
  } catch {
    return new Set<number>()
  }
}

function useStoredNumberSet(key: string) {
  const [values, setValues] = useState<Set<number>>(() => readNumberSet(key))

  const toggle = (value: number) => {
    setValues((current) => {
      const next = new Set(current)
      if (next.has(value)) next.delete(value)
      else next.add(value)
      localStorage.setItem(key, JSON.stringify([...next]))
      return next
    })
  }

  return [values, toggle] as const
}

function currentSlug() {
  const match = window.location.hash.match(/^#\/problem\/([^/]+)$/)
  return match?.[1] ?? null
}

function App() {
  const [slug, setSlug] = useState(currentSlug)
  const [problemDetail, setProblemDetail] = useState<Problem | null>(null)
  const [detailError, setDetailError] = useState<{ problemId: number; message: string } | null>(null)
  const [solved, toggleSolved] = useStoredNumberSet('atlas-solved')
  const [favorites, toggleFavorite] = useStoredNumberSet('atlas-favorites')
  const [theme, setTheme] = useState<Theme>(() =>
    localStorage.getItem('atlas-theme') === 'dark' ? 'dark' : 'light',
  )

  useEffect(() => {
    const onHashChange = () => {
      setSlug(currentSlug())
      window.scrollTo({ top: 0, behavior: 'instant' })
    }
    window.addEventListener('hashchange', onHashChange)
    return () => window.removeEventListener('hashchange', onHashChange)
  }, [])

  useEffect(() => {
    document.documentElement.dataset.theme = theme
    localStorage.setItem('atlas-theme', theme)
  }, [theme])

  const problem = slug ? problems.find((item) => item.slug === slug) : undefined

  useEffect(() => {
    let cancelled = false
    setProblemDetail(null)
    setDetailError(null)
    if (!problem || !hasProblemDetail(problem)) return () => { cancelled = true }

    loadProblemDetail(problem)
      .then((detail) => {
        if (!cancelled) setProblemDetail(detail)
      })
      .catch((error: unknown) => {
        if (!cancelled) {
          setDetailError({
            problemId: problem.id,
            message: error instanceof Error ? error.message : '题解加载失败',
          })
        }
      })
    return () => { cancelled = true }
  }, [problem])

  return (
    <div className="app-shell">
      <SiteHeader
        theme={theme}
        onToggleTheme={() => setTheme((value) => (value === 'light' ? 'dark' : 'light'))}
        onHome={() => {
          window.location.hash = '#/'
        }}
      />
      {problem ? (
        hasProblemDetail(problem) ? (
          problemDetail?.id === problem.id ? (
            <ProblemDetail
              problem={problemDetail}
              solved={solved.has(problem.id)}
              favorite={favorites.has(problem.id)}
              onToggleSolved={() => toggleSolved(problem.id)}
              onToggleFavorite={() => toggleFavorite(problem.id)}
              onOpen={(next) => {
                window.location.hash = `#/problem/${next.slug}`
              }}
            />
          ) : (
            <DetailLoading
              problem={problem}
              error={detailError?.problemId === problem.id ? detailError.message : null}
            />
          )
        ) : (
          <CatalogProblemDetail
            problem={problem}
            solved={solved.has(problem.id)}
            favorite={favorites.has(problem.id)}
            onToggleSolved={() => toggleSolved(problem.id)}
            onToggleFavorite={() => toggleFavorite(problem.id)}
            onOpen={(next) => {
              window.location.hash = `#/problem/${next.slug}`
            }}
          />
        )
      ) : (
        <Catalog
          solved={solved}
          favorites={favorites}
          onToggleSolved={toggleSolved}
          onToggleFavorite={toggleFavorite}
          onOpen={(next) => {
            window.location.hash = `#/problem/${next.slug}`
          }}
        />
      )}
      <SiteFooter />
    </div>
  )
}

function SiteHeader({
  theme,
  onToggleTheme,
  onHome,
}: {
  theme: Theme
  onToggleTheme: () => void
  onHome: () => void
}) {
  return (
    <header className="site-header">
      <button className="brand" onClick={onHome} aria-label="返回题库首页">
        <span className="brand-mark" aria-hidden="true">
          <span>{'{'}</span>
          <i />
          <span>{'}'}</span>
        </span>
        <span className="brand-copy">
          <strong>解法集</strong>
          <small>ALGORITHM ATLAS</small>
        </span>
      </button>
      <div className="header-meta">
        <span className="edition-badge">CATALOG · {problems.length}</span>
        <span className="header-divider" />
        <button className="icon-button" onClick={onToggleTheme} aria-label="切换明暗主题">
          {theme === 'light' ? <MoonIcon /> : <SunIcon />}
        </button>
      </div>
    </header>
  )
}

function Catalog({
  solved,
  favorites,
  onToggleSolved,
  onToggleFavorite,
  onOpen,
}: {
  solved: Set<number>
  favorites: Set<number>
  onToggleSolved: (id: number) => void
  onToggleFavorite: (id: number) => void
  onOpen: (problem: CatalogProblem) => void
}) {
  const [query, setQuery] = useState('')
  const [difficulty, setDifficulty] = useState<Difficulty | '全部'>('全部')
  const [category, setCategory] = useState('全部')
  const [progress, setProgress] = useState<ProgressFilter>('全部')
  const [content, setContent] = useState<ContentFilter>('全部内容')
  const [sort, setSort] = useState<SortMode>('题号')
  const [page, setPage] = useState(1)

  const filteredProblems = useMemo(() => {
    const keyword = query.trim().toLocaleLowerCase()
    return problems
      .filter((problem) => {
        const searchable = [
          problem.id,
          problem.title,
          problem.titleEn,
          problem.category,
          ...problem.officialTags,
          ...problem.studyTags,
        ]
          .join(' ')
          .toLocaleLowerCase()
        return (
          (!keyword || searchable.includes(keyword)) &&
          (difficulty === '全部' || problem.difficulty === difficulty) &&
          (category === '全部' || problem.category === category) &&
          (progress === '全部' || (progress === '已掌握' ? solved.has(problem.id) : !solved.has(problem.id))) &&
          (content === '全部内容' ||
            (content === '已有题解' && hasProblemDetail(problem)) ||
            (content === '待补充' && !hasProblemDetail(problem) && !problem.paidOnly) ||
            (content === '会员受限' && Boolean(problem.paidOnly)))
        )
      })
      .sort((a, b) => {
        if (sort === '难度') return difficultyOrder[a.difficulty] - difficultyOrder[b.difficulty] || a.id - b.id
        if (sort === '解法数') return getSolutionCount(b) - getSolutionCount(a) || a.id - b.id
        return a.id - b.id
      })
  }, [category, content, difficulty, progress, query, solved, sort])

  useEffect(() => {
    setPage(1)
  }, [category, content, difficulty, progress, query, sort])

  const totalPages = Math.max(1, Math.ceil(filteredProblems.length / PAGE_SIZE))
  const currentPage = Math.min(page, totalPages)
  const visibleProblems = filteredProblems.slice((currentPage - 1) * PAGE_SIZE, currentPage * PAGE_SIZE)

  const completedPercent = Math.round((solved.size / problems.length) * 100)

  const resetFilters = () => {
    setQuery('')
    setDifficulty('全部')
    setCategory('全部')
    setProgress('全部')
    setContent('全部内容')
  }

  return (
    <main>
      <section className="hero section-wrap">
        <div className="hero-copy">
          <p className="eyebrow"><span /> 一题多解 · 三语对照</p>
          <h1>不只收藏答案，<br /><em>真正看懂路径。</em></h1>
          <p className="hero-description">
            3000 道算法题可搜索、筛选与标记进度；已完成题解从朴素思路推演到最优实现，并提供 Java、Kotlin、C++ 对照代码。
          </p>
          <a className="primary-link" href="#catalog">
            浏览完整索引 <ArrowDownIcon />
          </a>
        </div>
        <div className="hero-dashboard" aria-label="题库内容统计">
          <div className="progress-orbit" style={{ '--progress': `${completedPercent * 3.6}deg` } as React.CSSProperties}>
            <div>
              <strong>{completedPercent}<sup>%</sup></strong>
              <span>学习进度</span>
            </div>
          </div>
          <div className="hero-stats">
            <div><strong>{problems.length}</strong><span>题目索引</span></div>
            <div><strong>{solutionCount}</strong><span>已完成解法</span></div>
            <div><strong>{implementationCount}</strong><span>已验证实现</span></div>
          </div>
          <div className="dashboard-note">
            <SparkIcon />
            <p><strong>本地记录</strong><span>进度与收藏保存在你的浏览器中</span></p>
          </div>
        </div>
      </section>

      <section className="catalog-section section-wrap" id="catalog">
        <div className="section-heading">
          <div>
            <p className="eyebrow"><span /> PROBLEM CATALOG</p>
            <h2>题目索引</h2>
          </div>
          <p>收录 {problems.length} 道算法题的题号、难度与标签；其中 {detailedProblemCount} 道已完成原创解析和三语言实现，{pendingProblemCount} 道公开题持续分批补充，{restrictedProblemCount} 道会员题保留索引。</p>
        </div>

        <div className="catalog-toolbar">
          <label className="search-box">
            <SearchIcon />
            <input
              value={query}
              onChange={(event) => setQuery(event.target.value)}
              placeholder="搜索题号、标题、标签或方法…"
            />
            {query && <button onClick={() => setQuery('')} aria-label="清空搜索">×</button>}
          </label>
          <div className="difficulty-tabs" aria-label="按难度筛选">
            {(['全部', '简单', '中等', '困难'] as const).map((item) => (
              <button
                key={item}
                className={difficulty === item ? 'active' : ''}
                onClick={() => setDifficulty(item)}
              >
                {item}
                {item !== '全部' && <span>{problems.filter((problem) => problem.difficulty === item).length}</span>}
              </button>
            ))}
          </div>
          <label className="sort-select">
            <span>排序</span>
            <select value={sort} onChange={(event) => setSort(event.target.value as SortMode)}>
              <option>题号</option>
              <option>难度</option>
              <option>解法数</option>
            </select>
          </label>
        </div>

        <div className="catalog-layout">
          <aside className="filter-sidebar">
            <FilterGroup title="学习状态">
              {(['全部', '未开始', '已掌握'] as ProgressFilter[]).map((item) => (
                <FilterButton
                  key={item}
                  active={progress === item}
                  label={item}
                  count={
                    item === '全部'
                      ? problems.length
                      : item === '已掌握'
                        ? solved.size
                        : problems.length - solved.size
                  }
                  onClick={() => setProgress(item)}
                />
              ))}
            </FilterGroup>
            <FilterGroup title="内容状态">
              {(['全部内容', '已有题解', '待补充', '会员受限'] as ContentFilter[]).map((item) => (
                <FilterButton
                  key={item}
                  active={content === item}
                  label={item}
                  count={
                    item === '全部内容'
                      ? problems.length
                      : item === '已有题解'
                        ? detailedProblemCount
                        : item === '待补充'
                          ? pendingProblemCount
                          : restrictedProblemCount
                  }
                  onClick={() => setContent(item)}
                />
              ))}
            </FilterGroup>
            <FilterGroup title="核心题型">
              <FilterButton
                active={category === '全部'}
                label="全部题型"
                count={problems.length}
                onClick={() => setCategory('全部')}
              />
              {categories.map((item) => (
                <FilterButton
                  key={item}
                  active={category === item}
                  label={item}
                  count={problems.filter((problem) => problem.category === item).length}
                  onClick={() => setCategory(item)}
                />
              ))}
            </FilterGroup>
            <div className="legend-card">
              <small>已完成题解代码</small>
              <div><LanguageDot color="java" /> Java</div>
              <div><LanguageDot color="kotlin" /> Kotlin</div>
              <div><LanguageDot color="cpp" /> C++</div>
            </div>
          </aside>

          <div className="problem-panel">
            <div className="result-summary">
              <span>
                匹配 <strong>{filteredProblems.length}</strong> 道
                {filteredProblems.length > PAGE_SIZE && <> · 第 {currentPage} / {totalPages} 页</>}
              </span>
              {(query || difficulty !== '全部' || category !== '全部' || progress !== '全部' || content !== '全部内容') && (
                <button onClick={resetFilters}>清除筛选</button>
              )}
            </div>
            {filteredProblems.length ? (
              <>
                <div className="problem-list">
                  {visibleProblems.map((problem) => (
                    <ProblemRow
                      key={problem.id}
                      problem={problem}
                      solved={solved.has(problem.id)}
                      favorite={favorites.has(problem.id)}
                      onOpen={() => onOpen(problem)}
                      onToggleSolved={() => onToggleSolved(problem.id)}
                      onToggleFavorite={() => onToggleFavorite(problem.id)}
                    />
                  ))}
                </div>
                {totalPages > 1 && (
                  <CatalogPagination
                    page={currentPage}
                    totalPages={totalPages}
                    onChange={(nextPage) => {
                      setPage(nextPage)
                      document.getElementById('catalog')?.scrollIntoView({ behavior: 'smooth' })
                    }}
                  />
                )}
              </>
            ) : (
              <div className="empty-state">
                <span>∅</span>
                <h3>没有匹配的题目</h3>
                <p>换一个关键词或清除部分筛选条件。</p>
                <button onClick={resetFilters}>重置筛选</button>
              </div>
            )}
          </div>
        </div>
      </section>
    </main>
  )
}

function FilterGroup({ title, children }: { title: string; children: React.ReactNode }) {
  return (
    <div className="filter-group">
      <h3>{title}</h3>
      <div>{children}</div>
    </div>
  )
}

function FilterButton({
  active,
  label,
  count,
  onClick,
}: {
  active: boolean
  label: string
  count: number
  onClick: () => void
}) {
  return (
    <button className={active ? 'active' : ''} onClick={onClick}>
      <span>{label}</span><small>{count}</small>
    </button>
  )
}

function CatalogPagination({
  page,
  totalPages,
  onChange,
}: {
  page: number
  totalPages: number
  onChange: (page: number) => void
}) {
  const candidates = [1, page - 1, page, page + 1, totalPages]
  const pages = [...new Set(candidates.filter((item) => item >= 1 && item <= totalPages))].sort((a, b) => a - b)

  return (
    <nav className="catalog-pagination" aria-label="题库分页">
      <button disabled={page === 1} onClick={() => onChange(page - 1)}><ArrowLeftIcon /> 上一页</button>
      <div>
        {pages.map((item, index) => (
          <span key={item}>
            {index > 0 && item - pages[index - 1] > 1 && <i>…</i>}
            <button className={item === page ? 'active' : ''} onClick={() => onChange(item)}>{item}</button>
          </span>
        ))}
      </div>
      <button disabled={page === totalPages} onClick={() => onChange(page + 1)}>下一页 <ArrowRightIcon /></button>
    </nav>
  )
}

function ProblemRow({
  problem,
  solved,
  favorite,
  onOpen,
  onToggleSolved,
  onToggleFavorite,
}: {
  problem: CatalogProblem
  solved: boolean
  favorite: boolean
  onOpen: () => void
  onToggleSolved: () => void
  onToggleFavorite: () => void
}) {
  const hasDetail = hasProblemDetail(problem)
  const rowTags = hasDetail ? problem.studyTags : problem.officialTags

  return (
    <article className={`problem-row ${solved ? 'is-solved' : ''} ${hasDetail ? 'has-detail' : 'is-catalog-only'}`}>
      <button
        className={`check-button ${solved ? 'checked' : ''}`}
        onClick={onToggleSolved}
        aria-label={solved ? '标记为未掌握' : '标记为已掌握'}
      >
        {solved && <CheckIcon />}
      </button>
      <button className="problem-main" onClick={onOpen}>
        <span className="problem-number" aria-label={`LeetCode 第 ${problem.id} 题`}>
          <small>LC</small> #{problem.id}
        </span>
        <span className="problem-title-block">
          <strong>{problem.title}</strong>
          {problem.title !== problem.titleEn && <small>{problem.titleEn}</small>}
          <span className="row-tags">
            {problem.paidOnly && <i className="paid-tag">会员</i>}
            {rowTags.slice(0, problem.paidOnly ? 1 : 2).map((tag) => <i key={tag}>{tag}</i>)}
          </span>
        </span>
      </button>
      <div className="problem-meta">
        <DifficultyBadge value={problem.difficulty} />
        {hasDetail ? (
          <>
            <span className="solution-total"><strong>{getSolutionCount(problem)}</strong> 种解法</span>
            <span className="language-dots" aria-label="包含 Java、Kotlin 和 C++">
              <LanguageDot color="java" /><LanguageDot color="kotlin" /><LanguageDot color="cpp" />
            </span>
          </>
        ) : (
          <span className="pending-solution">{problem.paidOnly ? '会员受限' : '题解待补充'}</span>
        )}
      </div>
      <button
        className={`favorite-button ${favorite ? 'active' : ''}`}
        onClick={onToggleFavorite}
        aria-label={favorite ? '取消收藏' : '收藏题目'}
      >
        <BookmarkIcon filled={favorite} />
      </button>
      <button className="row-arrow" onClick={onOpen} aria-label={`查看${problem.title}`}><ArrowRightIcon /></button>
    </article>
  )
}

function DetailLoading({ problem, error }: { problem: CatalogProblem; error: string | null }) {
  return (
    <main className="detail-page catalog-detail-page">
      <section className="detail-hero section-wrap">
        <nav className="breadcrumbs" aria-label="面包屑">
          <a href="#/">题目索引</a><span>/</span><span>{problem.category}</span><span>/</span><strong>{problem.title}</strong>
        </nav>
        <div className="detail-heading-row">
          <div className="detail-number"><small>LEETCODE</small><strong>#{problem.id}</strong></div>
          <div className="detail-title">
            <div className="detail-badges"><DifficultyBadge value={problem.difficulty} /><span>{problem.category}</span></div>
            <h1>{problem.title}</h1>
            {problem.title !== problem.titleEn && <p>{problem.titleEn}</p>}
          </div>
        </div>
      </section>
      <section className="pending-detail section-wrap">
        <article className="reading-card pending-detail-card">
          <div className="pending-symbol"><span>{error ? '!' : '{ }'}</span></div>
          <p className="card-kicker">{error ? 'LOAD ERROR' : 'LOADING'}</p>
          <h2>{error ? '题解加载失败' : '正在加载题解'}</h2>
          <p>{error ?? '代码和解析按题号独立加载，请稍候。'}</p>
          {error && <div className="pending-actions"><button onClick={() => window.location.reload()}>重新加载</button></div>}
        </article>
      </section>
    </main>
  )
}

function ProblemDetail({
  problem,
  solved,
  favorite,
  onToggleSolved,
  onToggleFavorite,
  onOpen,
}: {
  problem: Problem
  solved: boolean
  favorite: boolean
  onToggleSolved: () => void
  onToggleFavorite: () => void
  onOpen: (problem: CatalogProblem) => void
}) {
  const [solutionIndex, setSolutionIndex] = useState(0)
  const [language, setLanguage] = useState<Language>('java')
  const [copied, setCopied] = useState(false)
  const current = problem.solutions[solutionIndex] ?? problem.solutions[0]
  const problemIndex = problems.findIndex((item) => item.id === problem.id)
  const previous = problemIndex > 0 ? problems[problemIndex - 1] : null
  const next = problemIndex < problems.length - 1 ? problems[problemIndex + 1] : null

  useEffect(() => {
    setSolutionIndex(0)
    setLanguage('java')
    setCopied(false)
  }, [problem.id])

  const copyCode = async () => {
    await navigator.clipboard.writeText(current.code[language])
    setCopied(true)
    window.setTimeout(() => setCopied(false), 1600)
  }

  return (
    <main className="detail-page">
      <section className="detail-hero section-wrap">
        <nav className="breadcrumbs" aria-label="面包屑">
          <a href="#/">题目索引</a><span>/</span><span>{problem.category}</span><span>/</span><strong>{problem.title}</strong>
        </nav>
        <div className="detail-heading-row">
          <div className="detail-number" aria-label={`LeetCode 第 ${problem.id} 题`}>
            <small>LEETCODE</small>
            <strong>#{problem.id}</strong>
          </div>
          <div className="detail-title">
            <div className="detail-badges">
              <DifficultyBadge value={problem.difficulty} />
              <span>{problem.category}</span>
              {problem.paidOnly && <span className="paid-detail-badge">会员题</span>}
            </div>
            <h1>{problem.title}</h1>
            {problem.title !== problem.titleEn && <p>{problem.titleEn}</p>}
          </div>
          <div className="detail-actions">
            <button className={solved ? 'complete' : ''} onClick={onToggleSolved}>
              <CheckIcon /> {solved ? '已掌握' : '标记掌握'}
            </button>
            <button className={favorite ? 'favorite' : ''} onClick={onToggleFavorite} aria-label="切换收藏状态">
              <BookmarkIcon filled={favorite} />
            </button>
            <a href={problem.sourceUrl} target="_blank" rel="noreferrer">
              查看原题 <ExternalIcon />
            </a>
          </div>
        </div>
        <div className="tag-ribbons">
          <span>官方标签</span>
          {problem.officialTags.map((tag) => <i key={tag}>{tag}</i>)}
          <b />
          <span>学习标签</span>
          {problem.studyTags.map((tag) => <i className="study" key={tag}>{tag}</i>)}
        </div>
      </section>

      <section className="detail-content section-wrap">
        <div className="detail-main">
          <article className="reading-card overview-card">
            <p className="card-kicker">PROBLEM BRIEF</p>
            <h2>题意摘要</h2>
            <p className="summary-text">{problem.summary}</p>
            <div className="insight-box">
              <LightbulbIcon />
              <div><strong>破题关键</strong><p>{problem.insight}</p></div>
            </div>
          </article>

          <article className="reading-card solutions-card">
            <div className="solutions-heading">
              <div><p className="card-kicker">APPROACHES</p><h2>解法推演</h2></div>
              <span>共 {problem.solutions.length} 种</span>
            </div>
            <div className="approach-tabs" role="tablist">
              {problem.solutions.map((solution, index) => (
                <button
                  key={solution.id}
                  role="tab"
                  aria-selected={solutionIndex === index}
                  className={solutionIndex === index ? 'active' : ''}
                  onClick={() => setSolutionIndex(index)}
                >
                  <span>0{index + 1}</span>
                  <strong>{solution.title}</strong>
                  <small>{solution.kind}</small>
                </button>
              ))}
            </div>

            <div className="solution-intro">
              <div>
                <span className={`kind-badge kind-${current.kind}`}>{current.kind}</span>
                <h3>{current.title}</h3>
                <p>{current.idea}</p>
              </div>
              <div className="complexity-pills">
                <span><small>TIME</small><strong>{current.complexity.time}</strong></span>
                <span><small>SPACE</small><strong>{current.complexity.space}</strong></span>
              </div>
            </div>

            <ol className="solution-steps">
              {current.steps.map((step, index) => (
                <li key={step}><span>{index + 1}</span><p>{step}</p></li>
              ))}
            </ol>

            <div className="code-section">
              <div className="code-toolbar">
                <div className="language-tabs">
                  {(Object.keys(languageLabels) as Language[]).map((item) => (
                    <button key={item} className={language === item ? 'active' : ''} onClick={() => setLanguage(item)}>
                      <LanguageDot color={item} /> {languageLabels[item]}
                    </button>
                  ))}
                </div>
                <button className={copied ? 'copied' : ''} onClick={copyCode}>
                  {copied ? <CheckIcon /> : <CopyIcon />} {copied ? '已复制' : '复制代码'}
                </button>
              </div>
              <CodeBlock code={current.code[language]} />
            </div>
          </article>

          <article className="reading-card comparison-card">
            <p className="card-kicker">COMPARISON</p>
            <h2>横向比较</h2>
            <div className="comparison-table-wrap">
              <table>
                <thead><tr><th>解法</th><th>定位</th><th>时间</th><th>空间</th></tr></thead>
                <tbody>
                  {problem.solutions.map((solution, index) => (
                    <tr key={solution.id} className={index === solutionIndex ? 'active' : ''} onClick={() => setSolutionIndex(index)}>
                      <td><span>0{index + 1}</span><strong>{solution.title}</strong></td>
                      <td>{solution.kind}</td>
                      <td><code>{solution.complexity.time}</code></td>
                      <td><code>{solution.complexity.space}</code></td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </article>
        </div>

        <aside className="detail-sidebar">
          <div className="pitfall-card">
            <div><WarningIcon /><h2>易错点</h2></div>
            <ul>{problem.pitfalls.map((pitfall) => <li key={pitfall}>{pitfall}</li>)}</ul>
          </div>
          <div className="coverage-card">
            <p className="card-kicker">LANGUAGE COVERAGE</p>
            <h3>每个解法，三语齐全</h3>
            {(Object.keys(languageLabels) as Language[]).map((item) => (
              <div key={item}><LanguageDot color={item} /><span>{languageLabels[item]}</span><CheckIcon /></div>
            ))}
          </div>
          <div className="source-note">
            <ShieldIcon />
            <p><strong>内容说明</strong><span>本站提供原创摘要与解法，完整题目条件请以 LeetCode 原题为准。</span></p>
          </div>
        </aside>
      </section>

      <nav className="problem-pagination section-wrap" aria-label="相邻题目">
        {previous ? (
          <button onClick={() => onOpen(previous)}><ArrowLeftIcon /><span><small>上一题</small><strong>{previous.id}. {previous.title}</strong></span></button>
        ) : <span />}
        {next && (
          <button className="next" onClick={() => onOpen(next)}><span><small>下一题</small><strong>{next.id}. {next.title}</strong></span><ArrowRightIcon /></button>
        )}
      </nav>
    </main>
  )
}

function CatalogProblemDetail({
  problem,
  solved,
  favorite,
  onToggleSolved,
  onToggleFavorite,
  onOpen,
}: {
  problem: CatalogProblem
  solved: boolean
  favorite: boolean
  onToggleSolved: () => void
  onToggleFavorite: () => void
  onOpen: (problem: CatalogProblem) => void
}) {
  const problemIndex = problems.findIndex((item) => item.id === problem.id)
  const previous = problemIndex > 0 ? problems[problemIndex - 1] : null
  const next = problemIndex < problems.length - 1 ? problems[problemIndex + 1] : null

  return (
    <main className="detail-page catalog-detail-page">
      <section className="detail-hero section-wrap">
        <nav className="breadcrumbs" aria-label="面包屑">
          <a href="#/">题目索引</a><span>/</span><span>{problem.category}</span><span>/</span><strong>{problem.title}</strong>
        </nav>
        <div className="detail-heading-row">
          <div className="detail-number" aria-label={`LeetCode 第 ${problem.id} 题`}>
            <small>LEETCODE</small>
            <strong>#{problem.id}</strong>
          </div>
          <div className="detail-title">
            <div className="detail-badges">
              <DifficultyBadge value={problem.difficulty} />
              <span>{problem.category}</span>
              {problem.paidOnly && <span className="paid-detail-badge">会员题</span>}
            </div>
            <h1>{problem.title}</h1>
          </div>
          <div className="detail-actions">
            <button className={solved ? 'complete' : ''} onClick={onToggleSolved}>
              <CheckIcon /> {solved ? '已掌握' : '标记掌握'}
            </button>
            <button className={favorite ? 'favorite' : ''} onClick={onToggleFavorite} aria-label="切换收藏状态">
              <BookmarkIcon filled={favorite} />
            </button>
            <a href={problem.sourceUrl} target="_blank" rel="noreferrer">
              查看原题 <ExternalIcon />
            </a>
          </div>
        </div>
        <div className="tag-ribbons catalog-tag-ribbons">
          <span>题目标签</span>
          {problem.officialTags.length ? problem.officialTags.map((tag) => <i key={tag}>{tag}</i>) : <i>暂无标签</i>}
        </div>
      </section>

      <section className="pending-detail section-wrap">
        <article className="reading-card pending-detail-card">
          <div className="pending-symbol"><span>{'{ }'}</span></div>
          <p className="card-kicker">CATALOG ENTRY</p>
          <h2>{problem.paidOnly ? '题目已收录，内容受会员权限限制' : '题目已收录，题解待补充'}</h2>
          <p>
            {problem.paidOnly
              ? '当前页面只保留题号、难度、分类、标签与 LeetCode 原题链接，不抓取或转载会员题面。获得合法的题目契约后才会编写和验证原创题解。'
              : '当前页面已经保留题号、难度、分类、标签与 LeetCode 原题链接。原创题意摘要、最多三种解法及 Java、Kotlin、C++ 实现会按批次补充，并在完成编译验证后开放。'}
          </p>
          <div className="pending-actions">
            <a href={problem.sourceUrl} target="_blank" rel="noreferrer">前往 LeetCode 查看原题 <ExternalIcon /></a>
            <a href="#/">返回题目索引</a>
          </div>
        </article>
        <aside className="pending-metadata-card">
          <p className="card-kicker">METADATA</p>
          <h3>收录信息</h3>
          <dl>
            <div><dt>题号</dt><dd>LC #{problem.id}</dd></div>
            <div><dt>难度</dt><dd>{problem.difficulty}</dd></div>
            <div><dt>分类</dt><dd>{problem.category}</dd></div>
            <div><dt>访问</dt><dd>{problem.paidOnly ? '会员题' : '公开题'}</dd></div>
            <div><dt>题解状态</dt><dd><span>{problem.paidOnly ? '会员受限' : '待补充'}</span></dd></div>
          </dl>
          <div className="source-note">
            <ShieldIcon />
            <p><strong>不复制完整题面</strong><span>本站保留原题链接，仅发布原创摘要、分析与代码。</span></p>
          </div>
        </aside>
      </section>

      <nav className="problem-pagination section-wrap" aria-label="相邻题目">
        {previous ? (
          <button onClick={() => onOpen(previous)}><ArrowLeftIcon /><span><small>上一题</small><strong>{previous.id}. {previous.title}</strong></span></button>
        ) : <span />}
        {next && (
          <button className="next" onClick={() => onOpen(next)}><span><small>下一题</small><strong>{next.id}. {next.title}</strong></span><ArrowRightIcon /></button>
        )}
      </nav>
    </main>
  )
}

function CodeBlock({ code }: { code: string }) {
  return (
    <pre className="code-block" tabIndex={0}>
      <code>
        {code.split('\n').map((line, index) => (
          <span className="code-line" key={`${index}-${line}`}>
            <i>{String(index + 1).padStart(2, '0')}</i><b>{line || ' '}</b>
          </span>
        ))}
      </code>
    </pre>
  )
}

function DifficultyBadge({ value }: { value: Difficulty }) {
  return <span className={`difficulty difficulty-${value}`}>{value}</span>
}

function LanguageDot({ color }: { color: Language }) {
  return <i className={`language-dot dot-${color}`} />
}

function SiteFooter() {
  return (
    <footer className="site-footer section-wrap">
      <div className="footer-brand"><span>{'{ / }'}</span><p><strong>解法集</strong><small>Algorithm Atlas · 0.2</small></p></div>
      <p>
        原创题解 · 题库元数据来自{' '}
        <a href={`${catalogSource.repository}/tree/${catalogSource.commit}`} target="_blank" rel="noreferrer">MIT 数据快照</a>
      </p>
      <a href="#/">回到顶部 ↑</a>
    </footer>
  )
}

function SearchIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><circle cx="11" cy="11" r="6.5"/><path d="m16 16 4 4"/></svg> }
function ArrowDownIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M12 4v15m-6-6 6 6 6-6"/></svg> }
function ArrowRightIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M5 12h14m-6-6 6 6-6 6"/></svg> }
function ArrowLeftIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M19 12H5m6-6-6 6 6 6"/></svg> }
function ExternalIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M14 5h5v5M19 5l-9 9"/><path d="M18 13v5a1 1 0 0 1-1 1H6a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h5"/></svg> }
function CheckIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="m5 12 4 4L19 6"/></svg> }
function CopyIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><rect x="8" y="8" width="11" height="11" rx="2"/><path d="M16 8V6a2 2 0 0 0-2-2H6a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2"/></svg> }
function MoonIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M20 15.2A8 8 0 0 1 8.8 4 8 8 0 1 0 20 15.2Z"/></svg> }
function SunIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><circle cx="12" cy="12" r="4"/><path d="M12 2v2m0 16v2M4.9 4.9l1.4 1.4m11.4 11.4 1.4 1.4M2 12h2m16 0h2M4.9 19.1l1.4-1.4M17.7 6.3l1.4-1.4"/></svg> }
function SparkIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="m12 2 1.5 5.5L19 9l-5.5 1.5L12 16l-1.5-5.5L5 9l5.5-1.5L12 2Z"/><path d="m19 15 .7 2.3L22 18l-2.3.7L19 21l-.7-2.3L16 18l2.3-.7L19 15Z"/></svg> }
function LightbulbIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M9 18h6m-5 3h4M8.5 15.5A7 7 0 1 1 15.5 15.5c-.8.6-1.2 1.3-1.2 2.5H9.7c0-1.2-.4-1.9-1.2-2.5Z"/></svg> }
function WarningIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="m12 3 9 17H3L12 3Z"/><path d="M12 9v5m0 3v.1"/></svg> }
function ShieldIcon() { return <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M12 3 5 6v5c0 4.8 2.8 8 7 10 4.2-2 7-5.2 7-10V6l-7-3Z"/><path d="m9 12 2 2 4-4"/></svg> }
function BookmarkIcon({ filled }: { filled: boolean }) { return <svg viewBox="0 0 24 24" aria-hidden="true" className={filled ? 'filled' : ''}><path d="M6 4.5A1.5 1.5 0 0 1 7.5 3h9A1.5 1.5 0 0 1 18 4.5V21l-6-4-6 4V4.5Z"/></svg> }

export default App
