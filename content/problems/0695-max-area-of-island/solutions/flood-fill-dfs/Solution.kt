class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int { var best = 0; for (row in grid.indices) for (column in grid[0].indices) best = maxOf(best, area(grid, row, column)); return best }
    private fun area(grid: Array<IntArray>, row: Int, column: Int): Int { if (row !in grid.indices || column !in grid[0].indices || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1) }
}
