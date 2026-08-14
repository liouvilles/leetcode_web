class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val cost = IntArray(grid[0].size)
        cost[0] = grid[0][0]
        for (column in 1 until cost.size) cost[column] = cost[column - 1] + grid[0][column]
        for (row in 1 until grid.size) { cost[0] += grid[row][0]; for (column in 1 until cost.size) cost[column] = minOf(cost[column], cost[column - 1]) + grid[row][column] }
        return cost.last()
    }
}
