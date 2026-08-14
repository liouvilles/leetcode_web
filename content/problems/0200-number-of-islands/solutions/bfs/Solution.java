class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0, rows = grid.length, cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != '1') continue;
                count++;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[] {row, col});
                grid[row][col] = '0';
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    for (int[] direction : DIRECTIONS) {
                        int nr = cell[0] + direction[0], nc = cell[1] + direction[1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                            grid[nr][nc] = '0';
                            queue.offer(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
        return count;
    }
}
