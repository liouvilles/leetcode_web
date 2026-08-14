class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> pending; int fresh = 0;
        for (int row = 0; row < (int)grid.size(); ++row) for (int column = 0; column < (int)grid[0].size(); ++column) { if (grid[row][column] == 2) pending.push({row,column}); else if (grid[row][column] == 1) ++fresh; }
        int minutes = 0; int directions[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
        while (fresh > 0 && !pending.empty()) { int size = pending.size(); ++minutes; while (size--) { auto [r,c] = pending.front(); pending.pop(); for (auto& direction : directions) { int row = r + direction[0], column = c + direction[1]; if (row >= 0 && row < (int)grid.size() && column >= 0 && column < (int)grid[0].size() && grid[row][column] == 1) { grid[row][column] = 2; --fresh; pending.push({row,column}); } } } }
        return fresh == 0 ? minutes : -1;
    }
};
