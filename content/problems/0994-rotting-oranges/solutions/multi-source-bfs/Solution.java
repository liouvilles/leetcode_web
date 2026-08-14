class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>(); int fresh = 0;
        for (int row = 0; row < grid.length; row++) for (int column = 0; column < grid[0].length; column++) { if (grid[row][column] == 2) queue.offer(new int[] {row, column}); else if (grid[row][column] == 1) fresh++; }
        int minutes = 0; int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (fresh > 0 && !queue.isEmpty()) { int size = queue.size(); minutes++; while (size-- > 0) { int[] cell = queue.poll(); for (int[] direction : directions) { int row = cell[0] + direction[0], column = cell[1] + direction[1]; if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1) { grid[row][column] = 2; fresh--; queue.offer(new int[] {row, column}); } } } }
        return fresh == 0 ? minutes : -1;
    }
}
