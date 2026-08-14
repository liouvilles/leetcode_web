const d=200,n="number-of-islands",r="Number of Islands",u="中等",f="图论",i=["数组","深度优先搜索","广度优先搜索","并查集","矩阵"],g=!1,o="https://leetcode.cn/problems/number-of-islands/",c="岛屿数量",t=["网格连通块","沉岛法","四方向搜索"],l="在由陆地和水组成的网格中，统计上下左右相连的陆地连通块数量。",s="每次发现一块尚未访问的陆地，就找到了一个新岛；随后一次搜索可标记整座岛。",e=["只有上下左右连通，不含对角线","标记访问状态要在入栈或入队时完成","原地改网格会改变输入"],a=[{id:"dfs-sink",title:"DFS 沉岛",kind:"最优",idea:"发现陆地后把它及所有相连陆地递归改为水，避免重复计数。",steps:["扫描全部网格","遇到 1 时答案加一并启动 DFS","DFS 越界或遇水返回，否则标记并访问四邻域"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}},{id:"bfs",title:"队列 BFS",kind:"进阶",idea:"以新岛的首块陆地为起点，用队列逐层标记整个连通块。",steps:["发现新陆地后计数并立即标记","位置出队后检查四个邻居","未访问陆地在入队时标记"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}},{id:"union-find",title:"并查集",kind:"进阶",idea:"先把每块陆地视为独立集合，再合并相邻陆地；最终集合数就是岛屿数。",steps:["为每块陆地建立父结点并计数","只检查右方与下方邻居以避免重复","每次合并不同集合时将计数减一"],complexity:{time:"O(mn α(mn))",space:"O(mn)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}}],w={id:200,slug:n,titleEn:r,difficulty:"中等",category:"图论",officialTags:i,paidOnly:!1,sourceUrl:o,title:c,studyTags:t,summary:l,insight:s,pitfalls:e,solutions:a};export{f as category,w as default,u as difficulty,d as id,s as insight,i as officialTags,g as paidOnly,e as pitfalls,n as slug,a as solutions,o as sourceUrl,t as studyTags,l as summary,c as title,r as titleEn};
