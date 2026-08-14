class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = IntArray(obstacleGrid[0].size); dp[0] = if (obstacleGrid[0][0] == 0) 1 else 0
        for (row in obstacleGrid) for (column in row.indices) { if (row[column] == 1) dp[column] = 0 else if (column > 0) dp[column] += dp[column - 1] }
        return dp.last()
    }
}
