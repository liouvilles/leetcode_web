import type { Problem } from '../types'

export const dpGraphProblems: Problem[] = [
  {
    id: 70,
    slug: 'climbing-stairs',
    title: '爬楼梯',
    titleEn: 'Climbing Stairs',
    difficulty: '简单',
    category: '动态规划',
    officialTags: ['数学', '动态规划', '记忆化搜索'],
    studyTags: ['斐波那契型 DP', '状态压缩', '矩阵快速幂'],
    summary: '每次可以走一级或两级台阶，计算恰好到达第 n 级的不同走法数量。',
    insight: '到达第 i 级的最后一步只有两种来源，因此 ways[i] = ways[i-1] + ways[i-2]。',
    pitfalls: ['n 从 1 开始', 'ways[1] 与 ways[2] 的初值要匹配定义', '矩阵法内部乘法宜使用更宽整数类型'],
    sourceUrl: 'https://leetcode.cn/problems/climbing-stairs/',
    solutions: [
      {
        id: 'dp-array',
        title: '动态规划数组',
        kind: '基础',
        idea: '显式记录从第 0 级到第 n 级的走法数，直接套用递推式。',
        steps: ['定义 dp[0] = dp[1] = 1', '从 2 开始递推', '返回 dp[n]'],
        complexity: { time: 'O(n)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}`,
          kotlin: `class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]
    }
}`,
          cpp: `class Solution {
public:
    int climbStairs(int n) {
        vector<int> dp(n + 1);
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; ++i) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
};`,
        },
      },
      {
        id: 'rolling-dp',
        title: '滚动变量',
        kind: '最优',
        idea: '递推只依赖前两个状态，用两个变量滚动保存即可。',
        steps: ['previous 与 current 表示相邻两个状态', '计算 next 后整体前移', '循环结束返回 current'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int climbStairs(int n) {
        int previous = 1, current = 1;
        for (int step = 2; step <= n; step++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}`,
          kotlin: `class Solution {
    fun climbStairs(n: Int): Int {
        var previous = 1
        var current = 1
        for (step in 2..n) {
            val next = previous + current
            previous = current
            current = next
        }
        return current
    }
}`,
          cpp: `class Solution {
public:
    int climbStairs(int n) {
        int previous = 1, current = 1;
        for (int step = 2; step <= n; ++step) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
};`,
        },
      },
      {
        id: 'matrix-power',
        title: '矩阵快速幂',
        kind: '进阶',
        idea: '把斐波那契递推写成 2×2 矩阵乘法，再用二进制快速幂计算第 n 项。',
        steps: ['以单位矩阵初始化 result', '指数当前位为 1 时乘入 base', 'base 自乘且指数右移'],
        complexity: { time: 'O(log n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int climbStairs(int n) {
        long[][] result = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};
        int power = n;
        while (power > 0) {
            if ((power & 1) == 1) result = multiply(result, base);
            base = multiply(base, base);
            power >>= 1;
        }
        return (int) result[0][0];
    }

    private long[][] multiply(long[][] a, long[][] b) {
        return new long[][] {
            {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
            {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }
}`,
          kotlin: `class Solution {
    fun climbStairs(n: Int): Int {
        var result = longArrayOf(1, 0, 0, 1)
        var base = longArrayOf(1, 1, 1, 0)
        var power = n
        while (power > 0) {
            if (power and 1 == 1) result = multiply(result, base)
            base = multiply(base, base)
            power = power shr 1
        }
        return result[0].toInt()
    }

    private fun multiply(a: LongArray, b: LongArray) = longArrayOf(
        a[0] * b[0] + a[1] * b[2], a[0] * b[1] + a[1] * b[3],
        a[2] * b[0] + a[3] * b[2], a[2] * b[1] + a[3] * b[3]
    )
}`,
          cpp: `class Solution {
    using Matrix = array<long long, 4>;

public:
    int climbStairs(int n) {
        Matrix result{1, 0, 0, 1};
        Matrix base{1, 1, 1, 0};
        while (n > 0) {
            if (n & 1) result = multiply(result, base);
            base = multiply(base, base);
            n >>= 1;
        }
        return result[0];
    }

private:
    Matrix multiply(const Matrix& a, const Matrix& b) {
        return {a[0] * b[0] + a[1] * b[2], a[0] * b[1] + a[1] * b[3],
                a[2] * b[0] + a[3] * b[2], a[2] * b[1] + a[3] * b[3]};
    }
};`,
        },
      },
    ],
  },
  {
    id: 200,
    slug: 'number-of-islands',
    title: '岛屿数量',
    titleEn: 'Number of Islands',
    difficulty: '中等',
    category: '图搜索',
    officialTags: ['数组', '深度优先搜索', '广度优先搜索', '并查集', '矩阵'],
    studyTags: ['网格连通块', '沉岛法', '四方向搜索'],
    summary: '在由陆地和水组成的网格中，统计上下左右相连的陆地连通块数量。',
    insight: '每次发现一块尚未访问的陆地，就找到了一个新岛；随后一次搜索可标记整座岛。',
    pitfalls: ['只有上下左右连通，不含对角线', '标记访问状态要在入栈或入队时完成', '原地改网格会改变输入'],
    sourceUrl: 'https://leetcode.cn/problems/number-of-islands/',
    solutions: [
      {
        id: 'dfs-sink',
        title: 'DFS 沉岛',
        kind: '最优',
        idea: '发现陆地后把它及所有相连陆地递归改为水，避免重复计数。',
        steps: ['扫描全部网格', '遇到 1 时答案加一并启动 DFS', 'DFS 越界或遇水返回，否则标记并访问四邻域'],
        complexity: { time: 'O(mn)', space: 'O(mn)' },
        code: {
          java: `class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    sink(grid, row, col);
                }
            }
        }
        return count;
    }

    private void sink(char[][] grid, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length
                || grid[row][col] != '1') return;
        grid[row][col] = '0';
        sink(grid, row + 1, col); sink(grid, row - 1, col);
        sink(grid, row, col + 1); sink(grid, row, col - 1);
    }
}`,
          kotlin: `class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        fun sink(row: Int, col: Int) {
            if (row !in grid.indices || col !in grid[0].indices || grid[row][col] != '1') return
            grid[row][col] = '0'
            sink(row + 1, col); sink(row - 1, col)
            sink(row, col + 1); sink(row, col - 1)
        }
        for (row in grid.indices) for (col in grid[0].indices) {
            if (grid[row][col] == '1') {
                count++
                sink(row, col)
            }
        }
        return count
    }
}`,
          cpp: `class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for (int row = 0; row < (int)grid.size(); ++row)
            for (int col = 0; col < (int)grid[0].size(); ++col)
                if (grid[row][col] == '1') {
                    ++count;
                    sink(grid, row, col);
                }
        return count;
    }

private:
    void sink(vector<vector<char>>& grid, int row, int col) {
        if (row < 0 || row == (int)grid.size() || col < 0 || col == (int)grid[0].size()
                || grid[row][col] != '1') return;
        grid[row][col] = '0';
        sink(grid, row + 1, col); sink(grid, row - 1, col);
        sink(grid, row, col + 1); sink(grid, row, col - 1);
    }
};`,
        },
      },
      {
        id: 'bfs',
        title: '队列 BFS',
        kind: '进阶',
        idea: '以新岛的首块陆地为起点，用队列逐层标记整个连通块。',
        steps: ['发现新陆地后计数并立即标记', '位置出队后检查四个邻居', '未访问陆地在入队时标记'],
        complexity: { time: 'O(mn)', space: 'O(mn)' },
        code: {
          java: `class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0, rows = grid.length, cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != '1') continue;
                count++;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[] {row, col});
                grid[row][col] = '0';
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    for (int[] direction : DIRECTIONS) {
                        int nr = cell[0] + direction[0], nc = cell[1] + direction[1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                            grid[nr][nc] = '0';
                            queue.offer(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
        return count;
    }
}`,
          kotlin: `class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val directions = intArrayOf(1, 0, -1, 0, 1)
        var count = 0
        for (row in grid.indices) for (col in grid[0].indices) {
            if (grid[row][col] != '1') continue
            count++
            val queue = java.util.ArrayDeque<IntArray>()
            queue.offer(intArrayOf(row, col))
            grid[row][col] = '0'
            while (queue.isNotEmpty()) {
                val cell = queue.poll()
                for (d in 0 until 4) {
                    val nr = cell[0] + directions[d]
                    val nc = cell[1] + directions[d + 1]
                    if (nr in grid.indices && nc in grid[0].indices && grid[nr][nc] == '1') {
                        grid[nr][nc] = '0'
                        queue.offer(intArrayOf(nr, nc))
                    }
                }
            }
        }
        return count
    }
}`,
          cpp: `class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        const int directions[5] = {1, 0, -1, 0, 1};
        int count = 0;
        for (int row = 0; row < (int)grid.size(); ++row) {
            for (int col = 0; col < (int)grid[0].size(); ++col) {
                if (grid[row][col] != '1') continue;
                ++count;
                queue<pair<int, int>> cells;
                cells.push({row, col});
                grid[row][col] = '0';
                while (!cells.empty()) {
                    auto [r, c] = cells.front(); cells.pop();
                    for (int d = 0; d < 4; ++d) {
                        int nr = r + directions[d], nc = c + directions[d + 1];
                        if (nr >= 0 && nr < (int)grid.size() && nc >= 0 && nc < (int)grid[0].size()
                                && grid[nr][nc] == '1') {
                            grid[nr][nc] = '0';
                            cells.push({nr, nc});
                        }
                    }
                }
            }
        }
        return count;
    }
};`,
        },
      },
      {
        id: 'union-find',
        title: '并查集',
        kind: '进阶',
        idea: '先把每块陆地视为独立集合，再合并相邻陆地；最终集合数就是岛屿数。',
        steps: ['为每块陆地建立父结点并计数', '只检查右方与下方邻居以避免重复', '每次合并不同集合时将计数减一'],
        complexity: { time: 'O(mn α(mn))', space: 'O(mn)' },
        code: {
          java: `class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < rows; r++) for (int c = 0; c < cols; c++) {
            if (grid[r][c] != '1') continue;
            if (r + 1 < rows && grid[r + 1][c] == '1') uf.union(r * cols + c, (r + 1) * cols + c);
            if (c + 1 < cols && grid[r][c + 1] == '1') uf.union(r * cols + c, r * cols + c + 1);
        }
        return uf.count;
    }

    static class UnionFind {
        int[] parent, rank;
        int count;
        UnionFind(char[][] grid) {
            int cols = grid[0].length;
            parent = new int[grid.length * cols]; rank = new int[parent.length];
            Arrays.fill(parent, -1);
            for (int r = 0; r < grid.length; r++) for (int c = 0; c < cols; c++)
                if (grid[r][c] == '1') { parent[r * cols + c] = r * cols + c; count++; }
        }
        int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
        void union(int a, int b) {
            int ra = find(a), rb = find(b); if (ra == rb) return;
            if (rank[ra] < rank[rb]) { int temp = ra; ra = rb; rb = temp; }
            parent[rb] = ra; if (rank[ra] == rank[rb]) rank[ra]++; count--;
        }
    }
}`,
          kotlin: `class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val parent = IntArray(rows * cols) { -1 }
        val rank = IntArray(rows * cols)
        var count = 0
        for (r in 0 until rows) for (c in 0 until cols) if (grid[r][c] == '1') {
            parent[r * cols + c] = r * cols + c
            count++
        }
        fun find(start: Int): Int {
            var x = start
            while (parent[x] != x) {
                parent[x] = parent[parent[x]]
                x = parent[x]
            }
            return x
        }
        fun union(a: Int, b: Int) {
            var ra = find(a)
            var rb = find(b)
            if (ra == rb) return
            if (rank[ra] < rank[rb]) ra = rb.also { rb = ra }
            parent[rb] = ra
            if (rank[ra] == rank[rb]) rank[ra]++
            count--
        }
        for (r in 0 until rows) for (c in 0 until cols) if (grid[r][c] == '1') {
            if (r + 1 < rows && grid[r + 1][c] == '1') union(r * cols + c, (r + 1) * cols + c)
            if (c + 1 < cols && grid[r][c + 1] == '1') union(r * cols + c, r * cols + c + 1)
        }
        return count
    }
}`,
          cpp: `class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int rows = grid.size(), cols = grid[0].size(), count = 0;
        vector<int> parent(rows * cols, -1), rank(rows * cols);
        for (int r = 0; r < rows; ++r) for (int c = 0; c < cols; ++c)
            if (grid[r][c] == '1') parent[r * cols + c] = r * cols + c, ++count;
        function<int(int)> find = [&](int x) {
            return parent[x] == x ? x : parent[x] = find(parent[x]);
        };
        auto unite = [&](int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            if (rank[ra] < rank[rb]) swap(ra, rb);
            parent[rb] = ra;
            if (rank[ra] == rank[rb]) ++rank[ra];
            --count;
        };
        for (int r = 0; r < rows; ++r) for (int c = 0; c < cols; ++c) if (grid[r][c] == '1') {
            if (r + 1 < rows && grid[r + 1][c] == '1') unite(r * cols + c, (r + 1) * cols + c);
            if (c + 1 < cols && grid[r][c + 1] == '1') unite(r * cols + c, r * cols + c + 1);
        }
        return count;
    }
};`,
        },
      },
    ],
  },
  {
    id: 322,
    slug: 'coin-change',
    title: '零钱兑换',
    titleEn: 'Coin Change',
    difficulty: '中等',
    category: '动态规划',
    officialTags: ['广度优先搜索', '数组', '动态规划'],
    studyTags: ['完全背包', '最少步数', '记忆化搜索'],
    summary: '给定可无限使用的硬币面额，求组成目标金额所需的最少硬币数；无法组成时返回 -1。',
    insight: '金额 x 的最优答案来自某个可用硬币 coin 加上金额 x-coin 的最优答案。',
    pitfalls: ['硬币可以重复使用', '不可达状态不能参与最小值更新', '目标金额为 0 时答案是 0'],
    sourceUrl: 'https://leetcode.cn/problems/coin-change/',
    solutions: [
      {
        id: 'bottom-up-dp',
        title: '自底向上动态规划',
        kind: '最优',
        idea: 'dp[x] 表示凑成金额 x 的最少硬币数，从小金额逐步推到 amount。',
        steps: ['用 amount + 1 初始化不可达状态，dp[0] = 0', '枚举每个金额和可用硬币', '从已可达的较小金额转移并返回 dp[amount]'],
        complexity: { time: 'O(amount · k)', space: 'O(amount)' },
        code: {
          java: `class Solution {
    public int coinChange(int[] coins, int amount) {
        int unreachable = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, unreachable);
        dp[0] = 0;
        for (int value = 1; value <= amount; value++) {
            for (int coin : coins) {
                if (coin <= value) dp[value] = Math.min(dp[value], dp[value - coin] + 1);
            }
        }
        return dp[amount] == unreachable ? -1 : dp[amount];
    }
}`,
          kotlin: `class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val unreachable = amount + 1
        val dp = IntArray(amount + 1) { unreachable }
        dp[0] = 0
        for (value in 1..amount) for (coin in coins) {
            if (coin <= value) dp[value] = minOf(dp[value], dp[value - coin] + 1)
        }
        return if (dp[amount] == unreachable) -1 else dp[amount]
    }
}`,
          cpp: `class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int unreachable = amount + 1;
        vector<int> dp(amount + 1, unreachable);
        dp[0] = 0;
        for (int value = 1; value <= amount; ++value)
            for (int coin : coins)
                if (coin <= value) dp[value] = min(dp[value], dp[value - coin] + 1);
        return dp[amount] == unreachable ? -1 : dp[amount];
    }
};`,
        },
      },
      {
        id: 'memoized-dfs',
        title: '记忆化搜索',
        kind: '进阶',
        idea: '从目标金额向下尝试每种硬币，并缓存每个剩余金额的最优结果。',
        steps: ['剩余金额为 0 时成功、为负时失败', '读取或计算 memo[remain]', '汇总所有有效子问题的最小值'],
        complexity: { time: 'O(amount · k)', space: 'O(amount)' },
        code: {
          java: `class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        memo[0] = 0;
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int remain, int[] memo) {
        if (remain < 0) return -1;
        if (memo[remain] != -2) return memo[remain];
        int best = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dfs(coins, remain - coin, memo);
            if (sub >= 0) best = Math.min(best, sub + 1);
        }
        return memo[remain] = best == Integer.MAX_VALUE ? -1 : best;
    }
}`,
          kotlin: `class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val memo = IntArray(amount + 1) { -2 }
        memo[0] = 0
        fun dfs(remain: Int): Int {
            if (remain < 0) return -1
            if (memo[remain] != -2) return memo[remain]
            var best = Int.MAX_VALUE
            for (coin in coins) {
                val sub = dfs(remain - coin)
                if (sub >= 0) best = minOf(best, sub + 1)
            }
            memo[remain] = if (best == Int.MAX_VALUE) -1 else best
            return memo[remain]
        }
        return dfs(amount)
    }
}`,
          cpp: `class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> memo(amount + 1, -2);
        memo[0] = 0;
        function<int(int)> dfs = [&](int remain) {
            if (remain < 0) return -1;
            if (memo[remain] != -2) return memo[remain];
            int best = INT_MAX;
            for (int coin : coins) {
                int sub = dfs(remain - coin);
                if (sub >= 0) best = min(best, sub + 1);
            }
            return memo[remain] = best == INT_MAX ? -1 : best;
        };
        return dfs(amount);
    }
};`,
        },
      },
      {
        id: 'bfs-amounts',
        title: '金额状态 BFS',
        kind: '进阶',
        idea: '把金额视作图上的状态，每加一枚硬币走一条边；首次到达 amount 的层数就是最少硬币数。',
        steps: ['从金额 0 入队并标记', '逐层尝试加上每种硬币', '首次生成 amount 时返回当前层数加一'],
        complexity: { time: 'O(amount · k)', space: 'O(amount)' },
        code: {
          java: `class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        boolean[] visited = new boolean[amount + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0); visited[0] = true;
        int used = 0;
        while (!queue.isEmpty()) {
            used++;
            for (int size = queue.size(); size > 0; size--) {
                int current = queue.poll();
                for (int coin : coins) {
                    int next = current + coin;
                    if (next == amount) return used;
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}`,
          kotlin: `class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val visited = BooleanArray(amount + 1)
        val queue = java.util.ArrayDeque<Int>()
        queue.offer(0)
        visited[0] = true
        var used = 0
        while (queue.isNotEmpty()) {
            used++
            repeat(queue.size) {
                val current = queue.poll()
                for (coin in coins) {
                    val next = current + coin
                    if (next == amount) return used
                    if (next < amount && !visited[next]) {
                        visited[next] = true
                        queue.offer(next)
                    }
                }
            }
        }
        return -1
    }
}`,
          cpp: `class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (amount == 0) return 0;
        vector<bool> visited(amount + 1);
        queue<int> values;
        values.push(0); visited[0] = true;
        int used = 0;
        while (!values.empty()) {
            ++used;
            for (int size = values.size(); size > 0; --size) {
                int current = values.front(); values.pop();
                for (int coin : coins) {
                    int next = current + coin;
                    if (next == amount) return used;
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        values.push(next);
                    }
                }
            }
        }
        return -1;
    }
};`,
        },
      },
    ],
  },
  {
    id: 733,
    slug: 'flood-fill',
    title: '图像渲染',
    titleEn: 'Flood Fill',
    difficulty: '简单',
    category: '图搜索',
    officialTags: ['数组', '深度优先搜索', '广度优先搜索', '矩阵'],
    studyTags: ['网格搜索', '连通区域', '原地标记'],
    summary: '从指定像素出发，把所有与起点颜色相同且上下左右连通的像素改成新颜色。',
    insight: '这是以起点为源、以颜色相等为通行条件的连通块搜索。',
    pitfalls: ['原颜色等于新颜色时必须提前返回', '只允许四方向连接', '入队或递归前及时改色可充当 visited'],
    sourceUrl: 'https://leetcode.cn/problems/flood-fill/',
    solutions: [
      {
        id: 'recursive-dfs',
        title: '递归 DFS',
        kind: '最优',
        idea: '把当前像素改色后，递归处理仍为原颜色的四个邻居。',
        steps: ['保存起点原颜色并处理同色特例', '越界或颜色不同则返回', '改色并递归四邻域'],
        complexity: { time: 'O(mn)', space: 'O(mn)' },
        code: {
          java: `class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) fill(image, sr, sc, original, color);
        return image;
    }

    private void fill(int[][] image, int row, int col, int original, int color) {
        if (row < 0 || row == image.length || col < 0 || col == image[0].length
                || image[row][col] != original) return;
        image[row][col] = color;
        fill(image, row + 1, col, original, color); fill(image, row - 1, col, original, color);
        fill(image, row, col + 1, original, color); fill(image, row, col - 1, original, color);
    }
}`,
          kotlin: `class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val original = image[sr][sc]
        if (original == color) return image
        fun fill(row: Int, col: Int) {
            if (row !in image.indices || col !in image[0].indices || image[row][col] != original) return
            image[row][col] = color
            fill(row + 1, col); fill(row - 1, col)
            fill(row, col + 1); fill(row, col - 1)
        }
        fill(sr, sc)
        return image
    }
}`,
          cpp: `class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) fill(image, sr, sc, original, color);
        return image;
    }

private:
    void fill(vector<vector<int>>& image, int row, int col, int original, int color) {
        if (row < 0 || row == (int)image.size() || col < 0 || col == (int)image[0].size()
                || image[row][col] != original) return;
        image[row][col] = color;
        fill(image, row + 1, col, original, color); fill(image, row - 1, col, original, color);
        fill(image, row, col + 1, original, color); fill(image, row, col - 1, original, color);
    }
};`,
        },
      },
      {
        id: 'iterative-bfs',
        title: '队列 BFS',
        kind: '进阶',
        idea: '起点入队并改色，随后不断扩展仍为原颜色的相邻像素。',
        steps: ['处理原色与新色相同的特例', '起点改色后入队', '弹出位置并检查四邻域，命中原色就改色入队'],
        complexity: { time: 'O(mn)', space: 'O(mn)' },
        code: {
          java: `class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        int[] directions = {1, 0, -1, 0, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int d = 0; d < 4; d++) {
                int row = cell[0] + directions[d], col = cell[1] + directions[d + 1];
                if (row >= 0 && row < image.length && col >= 0 && col < image[0].length
                        && image[row][col] == original) {
                    image[row][col] = color;
                    queue.offer(new int[] {row, col});
                }
            }
        }
        return image;
    }
}`,
          kotlin: `class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val original = image[sr][sc]
        if (original == color) return image
        val directions = intArrayOf(1, 0, -1, 0, 1)
        val queue = java.util.ArrayDeque<IntArray>()
        queue.offer(intArrayOf(sr, sc))
        image[sr][sc] = color
        while (queue.isNotEmpty()) {
            val cell = queue.poll()
            for (d in 0 until 4) {
                val row = cell[0] + directions[d]
                val col = cell[1] + directions[d + 1]
                if (row in image.indices && col in image[0].indices && image[row][col] == original) {
                    image[row][col] = color
                    queue.offer(intArrayOf(row, col))
                }
            }
        }
        return image
    }
}`,
          cpp: `class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        const int directions[5] = {1, 0, -1, 0, 1};
        queue<pair<int, int>> cells;
        cells.push({sr, sc});
        image[sr][sc] = color;
        while (!cells.empty()) {
            auto [r, c] = cells.front(); cells.pop();
            for (int d = 0; d < 4; ++d) {
                int row = r + directions[d], col = c + directions[d + 1];
                if (row >= 0 && row < (int)image.size() && col >= 0 && col < (int)image[0].size()
                        && image[row][col] == original) {
                    image[row][col] = color;
                    cells.push({row, col});
                }
            }
        }
        return image;
    }
};`,
        },
      },
    ],
  },
]
