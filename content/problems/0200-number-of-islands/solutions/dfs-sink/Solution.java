class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    sink(grid, row, col);
                }
            }
        }
        return count;
    }

    private void sink(char[][] grid, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length
                || grid[row][col] != '1') return;
        grid[row][col] = '0';
        sink(grid, row + 1, col); sink(grid, row - 1, col);
        sink(grid, row, col + 1); sink(grid, row, col - 1);
    }
}
