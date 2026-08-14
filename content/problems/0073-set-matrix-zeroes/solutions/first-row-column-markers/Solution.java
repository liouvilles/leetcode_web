class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColumnZero = false;
        for (int column = 0; column < matrix[0].length; column++) if (matrix[0][column] == 0) firstRowZero = true;
        for (int row = 0; row < matrix.length; row++) if (matrix[row][0] == 0) firstColumnZero = true;
        for (int row = 1; row < matrix.length; row++) for (int column = 1; column < matrix[0].length; column++) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0; }
        for (int row = 1; row < matrix.length; row++) for (int column = 1; column < matrix[0].length; column++) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0;
        if (firstRowZero) Arrays.fill(matrix[0], 0);
        if (firstColumnZero) for (int[] row : matrix) row[0] = 0;
    }
}
