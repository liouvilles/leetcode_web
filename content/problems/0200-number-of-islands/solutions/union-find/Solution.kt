class Solution {
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
