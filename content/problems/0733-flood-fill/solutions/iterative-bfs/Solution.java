class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        int[] directions = {1, 0, -1, 0, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int d = 0; d < 4; d++) {
                int row = cell[0] + directions[d], col = cell[1] + directions[d + 1];
                if (row >= 0 && row < image.length && col >= 0 && col < image[0].length
                        && image[row][col] == original) {
                    image[row][col] = color;
                    queue.offer(new int[] {row, col});
                }
            }
        }
        return image;
    }
}
