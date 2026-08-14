class Solution {
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
