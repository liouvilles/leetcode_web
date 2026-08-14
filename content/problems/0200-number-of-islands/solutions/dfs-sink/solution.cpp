class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for (int row = 0; row < (int)grid.size(); ++row)
            for (int col = 0; col < (int)grid[0].size(); ++col)
                if (grid[row][col] == '1') {
                    ++count;
                    sink(grid, row, col);
                }
        return count;
    }

private:
    void sink(vector<vector<char>>& grid, int row, int col) {
        if (row < 0 || row == (int)grid.size() || col < 0 || col == (int)grid[0].size()
                || grid[row][col] != '1') return;
        grid[row][col] = '0';
        sink(grid, row + 1, col); sink(grid, row - 1, col);
        sink(grid, row, col + 1); sink(grid, row, col - 1);
    }
};
