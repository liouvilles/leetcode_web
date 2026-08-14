class Solution {
    int area(vector<vector<int>>& grid, int row, int column) { if (row < 0 || row >= (int)grid.size() || column < 0 || column >= (int)grid[0].size() || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1); }
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) { int best = 0; for (int row = 0; row < (int)grid.size(); ++row) for (int column = 0; column < (int)grid[0].size(); ++column) best = max(best, area(grid, row, column)); return best; }
};
