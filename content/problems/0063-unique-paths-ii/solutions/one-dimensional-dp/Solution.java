class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length]; dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] row : obstacleGrid) for (int column = 0; column < row.length; column++) { if (row[column] == 1) dp[column] = 0; else if (column > 0) dp[column] += dp[column - 1]; }
        return dp[dp.length - 1];
    }
}
