class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int best = 0; for (int row = 0; row < grid.length; row++) for (int column = 0; column < grid[0].length; column++) best = Math.max(best, area(grid, row, column)); return best;
    }
    private int area(int[][] grid, int row, int column) { if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1); }
}
