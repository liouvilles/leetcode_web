# 解法集 · Algorithm Atlas

一个面向算法学习的题库与多语言题解网页。当前收录 3000 道 LeetCode 算法题元数据；详细题解、解法数和三语言实现数量以构建时生成的 `src/generated/problem-manifest.json` 为准。

## 功能

- 3000 道算法题按关键词、难度、题型、内容状态和学习状态筛选
- 每页只渲染 50 道题，支持 60 页快速翻页
- 官方标签与学习标签分层展示
- 已完成题目提供最多三种解法，可横向比较复杂度
- Java、Kotlin、C++ 一键切换与复制
- 易错点、破题关键和解法步骤
- 本地保存学习进度、收藏和主题偏好
- 响应式布局与深色模式

本站不保存或展示完整题面和官方题解。每道题均保留力扣中国站原题链接；本站只发布原创题意摘要、分析与代码。

题库元数据快照来自 MIT 许可的 [noworneverev/leetcode-api](https://github.com/noworneverev/leetcode-api)，仅导入题号、英文标题、难度、标签、会员状态和原题 URL。详情见 [THIRD_PARTY_NOTICES.md](./THIRD_PARTY_NOTICES.md)。

## 本地运行

需要 Node.js 20.19+ 或 22.12+。

```bash
nvm use
npm install
npm run dev
```

生产构建：

```bash
npm run build
npm run preview
```

## 内容验证

数据模块加载时会检查：

- 题库数量不超过 3000，题号和 slug 不重复
- 每道完整题解包含 1～3 种解法
- 每种解法都包含三种语言实现

以下命令会进一步抽取全部代码并执行编译/语法检查：

```bash
npm run validate:snippets
```

新增题解还必须通过行为测试。每道 `qualityGate: tested` 的题至少配置三个测试用例，验证脚本会为 Java、Kotlin、C++ 分别生成可执行测试入口：

```bash
npm run validate:behavior
```

完整质量门禁：

```bash
npm run validate
```

验证脚本需要 `javac`、`g++` 和 `kotlinc`。脚本会优先寻找仓库环境中 Android Studio 附带的 Kotlin 编译器；如需在其他机器运行，可调整 `scripts/validate-snippets.mjs` 中的候选路径。

## 目录结构

```text
content/
└── problems/
    └── 0001-two-sum/         # 一题一目录：元数据、测试、三语言源文件
src/
├── App.tsx                    # 题库与题目详情界面
├── styles.css                # 主题、桌面端与移动端样式
├── types.ts                  # 题目、解法、代码的数据类型
└── data/
    ├── problems.ts           # 轻量目录与题解分片加载
    ├── problem-catalog.json  # 3000 题轻量元数据快照
    └── problems-*.ts         # 迁移前内容，仅供历史回退
└── generated/                # 由 content:build 生成，禁止手工编辑
scripts/
├── import-problem-catalog.mjs # 生成最多 3000 题的轻量目录
├── import-content-batch.mjs   # 原子导入一个题解批次
├── build-problem-content.mjs  # 生成网页清单与按题号详情分片
├── validate-content.mjs       # 内容结构和发布状态检查
├── validate-snippets.mjs      # 三语言代码编译检查
└── validate-behavior.mjs      # 三语言行为测试
```

## 更新题库目录

默认从脚本中固定的 MIT 数据快照重新生成目录：

```bash
npm run import:catalog
```

也可以传入已下载的上游 JSON，避免联网：

```bash
node scripts/import-problem-catalog.mjs /path/to/leetcode_questions.json
```

生成脚本主动丢弃题面、示例、提示、官方题解和代码模板，只保留网页索引所需的轻量字段。

## 增加题目

1. 在 `content/problems/<题号>-<slug>/` 下建立 `problem.json` 和 `tests.json`。
2. 每种解法分别保存 Java、Kotlin、C++ 源文件；新题必须使用 `qualityGate: tested`。
3. 每道题配置至少三个行为测试；设计题使用 `mode: design`，普通函数题使用 `mode: function`。
4. 运行 `npm run validate`，全部通过后才视为发布完成。

代码片段使用 LeetCode 提供的 `ListNode`、`TreeNode` 等环境类型，不需要在页面数据中重复声明。
