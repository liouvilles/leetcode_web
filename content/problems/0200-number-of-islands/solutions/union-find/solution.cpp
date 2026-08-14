class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int rows = grid.size(), cols = grid[0].size(), count = 0;
        vector<int> parent(rows * cols, -1), rank(rows * cols);
        for (int r = 0; r < rows; ++r) for (int c = 0; c < cols; ++c)
            if (grid[r][c] == '1') parent[r * cols + c] = r * cols + c, ++count;
        function<int(int)> find = [&](int x) {
            return parent[x] == x ? x : parent[x] = find(parent[x]);
        };
        auto unite = [&](int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            if (rank[ra] < rank[rb]) swap(ra, rb);
            parent[rb] = ra;
            if (rank[ra] == rank[rb]) ++rank[ra];
            --count;
        };
        for (int r = 0; r < rows; ++r) for (int c = 0; c < cols; ++c) if (grid[r][c] == '1') {
            if (r + 1 < rows && grid[r + 1][c] == '1') unite(r * cols + c, (r + 1) * cols + c);
            if (c + 1 < cols && grid[r][c + 1] == '1') unite(r * cols + c, r * cols + c + 1);
        }
        return count;
    }
};
