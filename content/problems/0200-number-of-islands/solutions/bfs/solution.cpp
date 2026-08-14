class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        const int directions[5] = {1, 0, -1, 0, 1};
        int count = 0;
        for (int row = 0; row < (int)grid.size(); ++row) {
            for (int col = 0; col < (int)grid[0].size(); ++col) {
                if (grid[row][col] != '1') continue;
                ++count;
                queue<pair<int, int>> cells;
                cells.push({row, col});
                grid[row][col] = '0';
                while (!cells.empty()) {
                    auto [r, c] = cells.front(); cells.pop();
                    for (int d = 0; d < 4; ++d) {
                        int nr = r + directions[d], nc = c + directions[d + 1];
                        if (nr >= 0 && nr < (int)grid.size() && nc >= 0 && nc < (int)grid[0].size()
                                && grid[nr][nc] == '1') {
                            grid[nr][nc] = '0';
                            cells.push({nr, nc});
                        }
                    }
                }
            }
        }
        return count;
    }
};
