const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 739, slug: 'daily-temperatures', title: '每日温度',
      studyTags: ['单调栈', '下一个更大元素', '下标差'],
      summary: '对每天的温度，计算还需等待多少天才会出现更高温度；若之后没有更高温度则为零。',
      insight: '栈保存尚未找到更高温度的日期，并保持温度非递增；新温度更高时可连续解决栈顶日期。',
      pitfalls: ['需要严格更高，相等温度不能出栈', '栈中保存下标用于计算天数', '未出栈位置答案保持初始零'],
      solutions: [s('monotonic-stack', '递减温度栈', '最优', '扫描新温度时弹出所有更低日期，并填写下标差。', ['栈保存未解决日期', '当前温度更高时反复弹栈', 'answer[old]=current-old 后压入当前下标'], 'O(n)', 'O(n)',
        `class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length]; Deque<Integer> stack = new ArrayDeque<>();
        for (int day = 0; day < temperatures.length; day++) { while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[day]) { int previous = stack.pop(); answer[previous] = day - previous; } stack.push(day); }
        return answer;
    }
}`,
        `class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size); val stack: ArrayDeque<Int> = ArrayDeque()
        for (day in temperatures.indices) { while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[day]) { val previous = stack.removeLast(); answer[previous] = day - previous }; stack.addLast(day) }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> answer(temperatures.size()), stack;
        for (int day = 0; day < (int)temperatures.size(); ++day) { while (!stack.empty() && temperatures[stack.back()] < temperatures[day]) { int previous = stack.back(); stack.pop_back(); answer[previous] = day - previous; } stack.push_back(day); }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'dailyTemperatures', parameterTypes: ['intArray'], returnType: 'intArray', cases: [
        { name: '温度升降交错', args: [[73, 74, 75, 71, 69, 72, 76, 73]], expected: [1, 1, 4, 2, 1, 1, 0, 0] },
        { name: '严格递增温度', args: [[30, 40, 50, 60]], expected: [1, 1, 1, 0] },
        { name: '严格递减温度', args: [[60, 50, 40]], expected: [0, 0, 0] },
      ] },
    },
    {
      id: 763, slug: 'partition-labels', title: '划分字母区间',
      studyTags: ['贪心', '最远出现位置', '区间闭合'],
      summary: '把字符串划分为尽可能多的连续片段，使每个字母最多出现在一个片段中，返回各片段长度。',
      insight: '扫描片段时，其内任一字符的最后出现位置都会扩展片段右边界；到达该最远边界时才能安全切分。',
      pitfalls: ['目标是片段数量尽可能多', '右边界要取当前片段所有字符最后位置的最大值', '切分后新片段从下一字符开始'],
      solutions: [s('last-occurrence-greedy', '最后位置贪心', '最优', '预处理每个字符的最后下标，再扫描形成最早可闭合区间。', ['记录 26 个字符最后位置', 'end=max(end,last[current])', 'index==end 时记录长度并更新 start'], 'O(n)', 'O(1)',
        `class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; for (int index = 0; index < s.length(); index++) last[s.charAt(index) - 'a'] = index;
        List<Integer> answer = new ArrayList<>(); int start = 0, end = 0;
        for (int index = 0; index < s.length(); index++) { end = Math.max(end, last[s.charAt(index) - 'a']); if (index == end) { answer.add(end - start + 1); start = index + 1; } }
        return answer;
    }
}`,
        `class Solution {
    fun partitionLabels(s: String): List<Int> {
        val last = IntArray(26); for (index in s.indices) last[s[index] - 'a'] = index
        val answer = ArrayList<Int>(); var start = 0; var end = 0
        for (index in s.indices) { end = maxOf(end, last[s[index] - 'a']); if (index == end) { answer.add(end - start + 1); start = index + 1 } }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> partitionLabels(string s) {
        array<int, 26> last{}; for (int index = 0; index < (int)s.size(); ++index) last[s[index] - 'a'] = index;
        vector<int> answer; int start = 0, end = 0;
        for (int index = 0; index < (int)s.size(); ++index) { end = max(end, last[s[index] - 'a']); if (index == end) { answer.push_back(end - start + 1); start = index + 1; } }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'partitionLabels', parameterTypes: ['string'], returnType: 'intList', cases: [
        { name: '划分成三个闭合区间', args: ['ababcbacadefegdehijhklij'], expected: [9, 7, 8] },
        { name: '前缀字符延伸至中部', args: ['eccbbbbdec'], expected: [10] },
        { name: '每个字符只出现一次', args: ['abc'], expected: [1, 1, 1] },
      ] },
    },
    {
      id: 785, slug: 'is-graph-bipartite', title: '判断二分图',
      studyTags: ['图染色', '深度优先搜索', '连通分量'],
      summary: '给定无向图邻接表，判断能否把节点分成两组，使每条边的两个端点属于不同组。',
      insight: '对每个连通分量执行二染色，相邻节点必须使用相反颜色；出现颜色冲突就不是二分图。',
      pitfalls: ['图可能不连通', '颜色零表示未访问', '已经染色的邻居需要检查颜色而不是跳过所有逻辑'],
      solutions: [s('dfs-coloring', 'DFS 二染色', '最优', '从每个未染色节点开始递归，用正负一代表两种颜色。', ['遍历全部节点覆盖每个分量', '未染色邻居赋相反颜色', '已染色邻居同色时失败'], 'O(V+E)', 'O(V)',
        `class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int node = 0; node < graph.length; node++) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false;
        return true;
    }
    private boolean paint(int[][] graph, int[] colors, int node, int color) { colors[node] = color; for (int next : graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false; } return true; }
}`,
        `class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val colors = IntArray(graph.size)
        for (node in graph.indices) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false
        return true
    }
    private fun paint(graph: Array<IntArray>, colors: IntArray, node: Int, color: Int): Boolean { colors[node] = color; for (next in graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false }; return true }
}`,
        `class Solution {
    bool paint(const vector<vector<int>>& graph, vector<int>& colors, int node, int color) { colors[node] = color; for (int next : graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false; } return true; }
public:
    bool isBipartite(vector<vector<int>>& graph) { vector<int> colors(graph.size()); for (int node = 0; node < (int)graph.size(); ++node) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false; return true; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isBipartite', parameterTypes: ['intMatrix'], returnType: 'boolean', cases: [
        { name: '奇环不是二分图', args: [[[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]]], expected: false },
        { name: '偶环可以二染色', args: [[[1, 3], [0, 2], [1, 3], [0, 2]]], expected: true },
        { name: '含孤立节点', args: [[[], [2], [1]]], expected: true },
      ] },
    },
    {
      id: 994, slug: 'rotting-oranges', title: '腐烂的橘子',
      studyTags: ['多源 BFS', '按层计时', '网格传播'],
      summary: '网格中腐烂橘子每分钟使上下左右相邻的新鲜橘子腐烂，求所有新鲜橘子腐烂的最短时间；无法完成则返回 -1。',
      insight: '所有初始腐烂橘子同时作为 BFS 源点，每扩展一层就代表经过一分钟。',
      pitfalls: ['初始没有新鲜橘子时答案为零', '同一新鲜橘子入队时就应标记腐烂', 'BFS 后仍有新鲜橘子则失败'],
      solutions: [s('multi-source-bfs', '多源分层 BFS', '最优', '初始腐烂位置全部入队，按层感染相邻新鲜位置。', ['统计新鲜橘子并收集所有源点', '每层处理当前队列长度并感染邻居', '新鲜数归零时返回分钟数，否则返回 -1'], 'O(mn)', 'O(mn)',
        `class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>(); int fresh = 0;
        for (int row = 0; row < grid.length; row++) for (int column = 0; column < grid[0].length; column++) { if (grid[row][column] == 2) queue.offer(new int[] {row, column}); else if (grid[row][column] == 1) fresh++; }
        int minutes = 0; int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (fresh > 0 && !queue.isEmpty()) { int size = queue.size(); minutes++; while (size-- > 0) { int[] cell = queue.poll(); for (int[] direction : directions) { int row = cell[0] + direction[0], column = cell[1] + direction[1]; if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1) { grid[row][column] = 2; fresh--; queue.offer(new int[] {row, column}); } } } }
        return fresh == 0 ? minutes : -1;
    }
}`,
        `class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue: ArrayDeque<IntArray> = ArrayDeque(); var fresh = 0
        for (row in grid.indices) for (column in grid[0].indices) if (grid[row][column] == 2) queue.add(intArrayOf(row, column)) else if (grid[row][column] == 1) fresh++
        val directions = arrayOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0,-1)); var minutes = 0
        while (fresh > 0 && queue.isNotEmpty()) { repeat(queue.size) { val cell = queue.removeFirst(); for (direction in directions) { val row = cell[0] + direction[0]; val column = cell[1] + direction[1]; if (row in grid.indices && column in grid[0].indices && grid[row][column] == 1) { grid[row][column] = 2; fresh--; queue.add(intArrayOf(row, column)) } } }; minutes++ }
        return if (fresh == 0) minutes else -1
    }
}`,
        `class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> pending; int fresh = 0;
        for (int row = 0; row < (int)grid.size(); ++row) for (int column = 0; column < (int)grid[0].size(); ++column) { if (grid[row][column] == 2) pending.push({row,column}); else if (grid[row][column] == 1) ++fresh; }
        int minutes = 0; int directions[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
        while (fresh > 0 && !pending.empty()) { int size = pending.size(); ++minutes; while (size--) { auto [r,c] = pending.front(); pending.pop(); for (auto& direction : directions) { int row = r + direction[0], column = c + direction[1]; if (row >= 0 && row < (int)grid.size() && column >= 0 && column < (int)grid[0].size() && grid[row][column] == 1) { grid[row][column] = 2; --fresh; pending.push({row,column}); } } } }
        return fresh == 0 ? minutes : -1;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'orangesRotting', parameterTypes: ['intMatrix'], returnType: 'int', cases: [
        { name: '四分钟传播到全部位置', args: [[[2, 1, 1], [1, 1, 0], [0, 1, 1]]], expected: 4 },
        { name: '新鲜橘子被空格隔断', args: [[[2, 1, 1], [0, 1, 1], [1, 0, 1]]], expected: -1 },
        { name: '没有新鲜橘子', args: [[[0, 2]]], expected: 0 },
      ] },
    },
    {
      id: 1143, slug: 'longest-common-subsequence', title: '最长公共子序列',
      studyTags: ['二维动态规划', '字符串子序列', '前缀状态'],
      summary: '求两个字符串共同子序列的最大长度，子序列保留相对顺序但不要求连续。',
      insight: '末字符相同就接在两个更短前缀的最优子序列后；不同则至少舍弃其中一个末字符并取较优结果。',
      pitfalls: ['子序列不要求连续', '字符相同时转移自左上角加一', '字符不同时取上方与左方最大值'],
      solutions: [s('prefix-dp', '双前缀动态规划', '最优', 'dp[i][j] 表示两个长度为 i、j 的前缀的最长公共子序列长度。', ['空前缀边界保持零', '末字符相同则 dp[i-1][j-1]+1', '否则 max(dp[i-1][j],dp[i][j-1])'], 'O(mn)', 'O(mn)',
        `class Solution {
    public int longestCommonSubsequence(String first, String second) {
        int[][] length = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) for (int j = 1; j <= second.length(); j++) length[i][j] = first.charAt(i - 1) == second.charAt(j - 1) ? length[i - 1][j - 1] + 1 : Math.max(length[i - 1][j], length[i][j - 1]);
        return length[first.length()][second.length()];
    }
}`,
        `class Solution {
    fun longestCommonSubsequence(first: String, second: String): Int {
        val length = Array(first.length + 1) { IntArray(second.length + 1) }
        for (i in 1..first.length) for (j in 1..second.length) length[i][j] = if (first[i - 1] == second[j - 1]) length[i - 1][j - 1] + 1 else maxOf(length[i - 1][j], length[i][j - 1])
        return length[first.length][second.length]
    }
}`,
        `class Solution {
public:
    int longestCommonSubsequence(string first, string second) {
        vector<vector<int>> length(first.size() + 1, vector<int>(second.size() + 1));
        for (int i = 1; i <= (int)first.size(); ++i) for (int j = 1; j <= (int)second.size(); ++j) length[i][j] = first[i - 1] == second[j - 1] ? length[i - 1][j - 1] + 1 : max(length[i - 1][j], length[i][j - 1]);
        return length[first.size()][second.size()];
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'longestCommonSubsequence', parameterTypes: ['string', 'string'], returnType: 'int', cases: [
        { name: '跳过字符形成公共子序列', args: ['abcde', 'ace'], expected: 3 },
        { name: '两个字符串完全相同', args: ['abc', 'abc'], expected: 3 },
        { name: '没有公共字符', args: ['abc', 'def'], expected: 0 },
      ] },
    },
  ],
}
