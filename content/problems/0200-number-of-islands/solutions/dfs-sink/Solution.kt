class Solution {
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
