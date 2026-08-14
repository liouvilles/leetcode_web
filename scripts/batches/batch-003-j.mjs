const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 295, slug: 'find-median-from-data-stream', title: '数据流的中位数',
      studyTags: ['设计题', '双堆', '数据流'],
      summary: '设计数据结构，持续加入整数，并能随时返回当前所有元素的中位数。',
      insight: '最大堆保存较小的一半，最小堆保存较大的一半；保持两堆大小相差不超过一且最大堆不少于最小堆。',
      pitfalls: ['偶数个元素时中位数是两个堆顶平均值', '求和前转换为浮点或长整型避免溢出', '每次加入后都要恢复大小平衡'],
      solutions: [s('two-heaps', '最大堆 + 最小堆', '最优', '用两个堆维护数据流的下半区和上半区。', ['新值先加入最大堆，再把最大值移到最小堆', '若最小堆更大则把其最小值移回', '按总数量奇偶读取一个或两个堆顶'], 'O(log n) add, O(1) median', 'O(n)',
        `class MedianFinder {
    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();
    public MedianFinder() {}
    public void addNum(int num) { lower.offer(num); upper.offer(lower.poll()); if (upper.size() > lower.size()) lower.offer(upper.poll()); }
    public double findMedian() { return lower.size() > upper.size() ? lower.peek() : ((long) lower.peek() + upper.peek()) / 2.0; }
}`,
        `class MedianFinder {
    private val lower = PriorityQueue<Int>(compareByDescending { it })
    private val upper = PriorityQueue<Int>()
    fun addNum(num: Int) { lower.add(num); upper.add(lower.remove()); if (upper.size > lower.size) lower.add(upper.remove()) }
    fun findMedian(): Double = if (lower.size > upper.size) lower.element().toDouble() else (lower.element().toLong() + upper.element()) / 2.0
}`,
        `class MedianFinder {
    priority_queue<int> lower;
    priority_queue<int, vector<int>, greater<int>> upper;
public:
    MedianFinder() {}
    void addNum(int num) { lower.push(num); upper.push(lower.top()); lower.pop(); if (upper.size() > lower.size()) { lower.push(upper.top()); upper.pop(); } }
    double findMedian() { return lower.size() > upper.size() ? lower.top() : ((long long)lower.top() + upper.top()) / 2.0; }
};`)],
      tests: { schemaVersion: 1, mode: 'design', className: 'MedianFinder', constructorTypes: [], cases: [
        { name: '奇偶数量交替查询', constructorArgs: [], calls: [
          { method: 'addNum', parameterTypes: ['int'], args: [1] }, { method: 'addNum', parameterTypes: ['int'], args: [2] },
          { method: 'findMedian', parameterTypes: [], args: [], returnType: 'double', expected: 1.5 },
          { method: 'addNum', parameterTypes: ['int'], args: [3] }, { method: 'findMedian', parameterTypes: [], args: [], returnType: 'double', expected: 2.0 },
        ] },
        { name: '包含负数', constructorArgs: [], calls: [
          { method: 'addNum', parameterTypes: ['int'], args: [-1] }, { method: 'addNum', parameterTypes: ['int'], args: [-2] },
          { method: 'findMedian', parameterTypes: [], args: [], returnType: 'double', expected: -1.5 },
        ] },
        { name: '单元素数据流', constructorArgs: [], calls: [
          { method: 'addNum', parameterTypes: ['int'], args: [7] }, { method: 'findMedian', parameterTypes: [], args: [], returnType: 'double', expected: 7.0 },
        ] },
      ] },
    },
    {
      id: 338, slug: 'counting-bits', title: '比特位计数',
      studyTags: ['动态规划', '最低位', '位运算'],
      summary: '对从 0 到 n 的每个整数，返回其二进制表示中一位的数量。',
      insight: 'i 右移一位会去掉最低位，因此 bits[i]=bits[i>>1]+(i&1)。',
      pitfalls: ['答案包含零对应的位置', '数组长度为 n+1', '最低位贡献只有零或一'],
      solutions: [s('lowest-bit-dp', '右移递推', '最优', '复用更小整数的计数并加上当前最低位。', ['bits[0] 默认为零', '从一遍历到 n', '按 bits[i>>1]+(i&1) 计算'], 'O(n)', 'O(n)',
        `class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1]; for (int value = 1; value <= n; value++) bits[value] = bits[value >> 1] + (value & 1); return bits;
    }
}`,
        `class Solution {
    fun countBits(n: Int): IntArray { val bits = IntArray(n + 1); for (value in 1..n) bits[value] = bits[value shr 1] + (value and 1); return bits }
}`,
        `class Solution {
public:
    vector<int> countBits(int n) { vector<int> bits(n + 1); for (int value = 1; value <= n; ++value) bits[value] = bits[value >> 1] + (value & 1); return bits; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'countBits', parameterTypes: ['int'], returnType: 'intArray', cases: [
        { name: '统计到二', args: [2], expected: [0, 1, 1] },
        { name: '统计到五', args: [5], expected: [0, 1, 1, 2, 1, 2] },
        { name: '只有零', args: [0], expected: [0] },
      ] },
    },
    {
      id: 371, slug: 'sum-of-two-integers', title: '两整数之和',
      studyTags: ['位运算', '异或', '进位'],
      summary: '不使用加法和减法运算符，计算两个整数的和。',
      insight: '异或得到不含进位的和，与运算后左移一位得到进位；重复直到进位为零。',
      pitfalls: ['负数按固定宽度补码同样适用', '进位必须左移一位', '循环结束时 a 保存完整结果'],
      solutions: [s('xor-carry', '异或和进位迭代', '最优', '把加法拆成无进位求和与进位传播两部分。', ['sum=a xor b', 'carry=(a&b)<<1', '令 a=sum、b=carry 直到 b 为零'], 'O(32)', 'O(1)',
        `class Solution {
    public int getSum(int a, int b) {
        while (b != 0) { int carry = (a & b) << 1; a ^= b; b = carry; } return a;
    }
}`,
        `class Solution {
    fun getSum(first: Int, second: Int): Int { var a = first; var b = second; while (b != 0) { val carry = (a and b) shl 1; a = a xor b; b = carry }; return a }
}`,
        `class Solution {
public:
    int getSum(int a, int b) { while (b != 0) { unsigned int carry = ((unsigned int)a & (unsigned int)b) << 1; a ^= b; b = carry; } return a; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'getSum', parameterTypes: ['int', 'int'], returnType: 'int', cases: [
        { name: '两个正数', args: [1, 2], expected: 3 },
        { name: '正数与负数', args: [-2, 3], expected: 1 },
        { name: '两个负数', args: [-5, -7], expected: -12 },
      ] },
    },
    {
      id: 684, slug: 'redundant-connection', title: '冗余连接',
      studyTags: ['并查集', '环检测', '无向图'],
      summary: '一棵 n 节点树额外加入一条边后，找出可以删除使图重新成为树的那条边。',
      insight: '按输入顺序加入边，若两个端点已经属于同一连通分量，当前边就是形成环的冗余边。',
      pitfalls: ['节点编号从一开始', '需要按输入顺序处理边', '路径压缩可降低查找开销'],
      solutions: [s('union-find', '并查集判环', '最优', '每条边尝试合并两个集合，合并失败时返回当前边。', ['初始化每个节点父亲为自身', 'find 使用路径压缩', '根相同则当前边冗余，否则连接两个根'], 'O(n α(n))', 'O(n)',
        `class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1]; for (int node = 1; node < parent.length; node++) parent[node] = node;
        for (int[] edge : edges) { int first = find(parent, edge[0]), second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second; }
        return new int[0];
    }
    private int find(int[] parent, int node) { if (parent[node] != node) parent[node] = find(parent, parent[node]); return parent[node]; }
}`,
        `class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) { it }
        for (edge in edges) { val first = find(parent, edge[0]); val second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second }
        return intArrayOf()
    }
    private fun find(parent: IntArray, node: Int): Int { if (parent[node] != node) parent[node] = find(parent, parent[node]); return parent[node] }
}`,
        `class Solution {
    int find(vector<int>& parent, int node) { return parent[node] == node ? node : parent[node] = find(parent, parent[node]); }
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<int> parent(edges.size() + 1); iota(parent.begin(), parent.end(), 0);
        for (auto& edge : edges) { int first = find(parent, edge[0]), second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second; }
        return {};
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'findRedundantConnection', parameterTypes: ['intMatrix'], returnType: 'intArray', cases: [
        { name: '三节点环', args: [[[1, 2], [1, 3], [2, 3]]], expected: [2, 3] },
        { name: '环在图后半部分闭合', args: [[[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]]], expected: [1, 4] },
        { name: '最小环', args: [[[1, 2], [2, 3], [3, 1]]], expected: [3, 1] },
      ] },
    },
    {
      id: 695, slug: 'max-area-of-island', title: '岛屿的最大面积',
      studyTags: ['网格 DFS', '连通分量', '原地标记'],
      summary: '在只含零和一的网格中，求上下左右相连的一组成陆地格子的最大数量。',
      insight: '每遇到未访问陆地就启动一次 DFS，递归淹没整个连通分量并累计面积。',
      pitfalls: ['只按四个方向连接', '访问时立即置零防止重复计数', '没有陆地时答案为零'],
      solutions: [s('flood-fill-dfs', '原地淹没 DFS', '最优', '把访问过的陆地改为零，同时返回当前连通分量面积。', ['遍历所有格子寻找陆地', 'DFS 越界或遇水返回零', '当前格置零并返回一加四邻面积'], 'O(mn)', 'O(mn)',
        `class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int best = 0; for (int row = 0; row < grid.length; row++) for (int column = 0; column < grid[0].length; column++) best = Math.max(best, area(grid, row, column)); return best;
    }
    private int area(int[][] grid, int row, int column) { if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1); }
}`,
        `class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int { var best = 0; for (row in grid.indices) for (column in grid[0].indices) best = maxOf(best, area(grid, row, column)); return best }
    private fun area(grid: Array<IntArray>, row: Int, column: Int): Int { if (row !in grid.indices || column !in grid[0].indices || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1) }
}`,
        `class Solution {
    int area(vector<vector<int>>& grid, int row, int column) { if (row < 0 || row >= (int)grid.size() || column < 0 || column >= (int)grid[0].size() || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1); }
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) { int best = 0; for (int row = 0; row < (int)grid.size(); ++row) for (int column = 0; column < (int)grid[0].size(); ++column) best = max(best, area(grid, row, column)); return best; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'maxAreaOfIsland', parameterTypes: ['intMatrix'], returnType: 'int', cases: [
        { name: '多个岛屿取最大分量', args: [[[0, 0, 1, 0], [1, 1, 1, 0], [0, 1, 0, 1]]], expected: 5 },
        { name: '全是水', args: [[[0, 0], [0, 0]]], expected: 0 },
        { name: '单格陆地', args: [[[1]]], expected: 1 },
      ] },
    },
  ],
}
