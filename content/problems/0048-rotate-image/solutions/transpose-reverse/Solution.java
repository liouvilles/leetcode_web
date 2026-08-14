class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) for (int column = row + 1; column < n; column++) { int value = matrix[row][column]; matrix[row][column] = matrix[column][row]; matrix[column][row] = value; }
        for (int[] row : matrix) for (int left = 0, right = n - 1; left < right; left++, right--) { int value = row[left]; row[left] = row[right]; row[right] = value; }
    }
}
