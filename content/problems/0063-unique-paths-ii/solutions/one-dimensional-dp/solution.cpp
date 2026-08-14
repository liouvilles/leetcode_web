class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<int> dp(obstacleGrid[0].size()); dp[0] = obstacleGrid[0][0] == 0;
        for (const auto& row : obstacleGrid) for (int column = 0; column < (int)row.size(); ++column) { if (row[column] == 1) dp[column] = 0; else if (column > 0) dp[column] += dp[column - 1]; }
        return dp.back();
    }
};
