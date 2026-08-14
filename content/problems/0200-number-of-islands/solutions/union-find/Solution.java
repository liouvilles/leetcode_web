class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < rows; r++) for (int c = 0; c < cols; c++) {
            if (grid[r][c] != '1') continue;
            if (r + 1 < rows && grid[r + 1][c] == '1') uf.union(r * cols + c, (r + 1) * cols + c);
            if (c + 1 < cols && grid[r][c + 1] == '1') uf.union(r * cols + c, r * cols + c + 1);
        }
        return uf.count;
    }

    static class UnionFind {
        int[] parent, rank;
        int count;
        UnionFind(char[][] grid) {
            int cols = grid[0].length;
            parent = new int[grid.length * cols]; rank = new int[parent.length];
            Arrays.fill(parent, -1);
            for (int r = 0; r < grid.length; r++) for (int c = 0; c < cols; c++)
                if (grid[r][c] == '1') { parent[r * cols + c] = r * cols + c; count++; }
        }
        int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
        void union(int a, int b) {
            int ra = find(a), rb = find(b); if (ra == rb) return;
            if (rank[ra] < rank[rb]) { int temp = ra; ra = rb; rb = temp; }
            parent[rb] = ra; if (rank[ra] == rank[rb]) rank[ra]++; count--;
        }
    }
}
