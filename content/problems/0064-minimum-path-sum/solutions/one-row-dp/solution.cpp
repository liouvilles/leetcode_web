class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        vector<int> cost(grid[0].size());
        cost[0] = grid[0][0];
        for (int column = 1; column < (int)cost.size(); ++column) cost[column] = cost[column - 1] + grid[0][column];
        for (int row = 1; row < (int)grid.size(); ++row) { cost[0] += grid[row][0]; for (int column = 1; column < (int)cost.size(); ++column) cost[column] = min(cost[column], cost[column - 1]) + grid[row][column]; }
        return cost.back();
    }
};
