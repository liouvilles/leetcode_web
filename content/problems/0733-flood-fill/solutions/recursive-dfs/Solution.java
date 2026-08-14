class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) fill(image, sr, sc, original, color);
        return image;
    }

    private void fill(int[][] image, int row, int col, int original, int color) {
        if (row < 0 || row == image.length || col < 0 || col == image[0].length
                || image[row][col] != original) return;
        image[row][col] = color;
        fill(image, row + 1, col, original, color); fill(image, row - 1, col, original, color);
        fill(image, row, col + 1, original, color); fill(image, row, col - 1, original, color);
    }
}
