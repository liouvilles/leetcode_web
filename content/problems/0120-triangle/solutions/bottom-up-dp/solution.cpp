class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) { vector<int> dp(triangle.size() + 1); for (int row = triangle.size() - 1; row >= 0; --row) for (int column = 0; column <= row; ++column) dp[column] = triangle[row][column] + min(dp[column], dp[column + 1]); return dp[0]; }
};
