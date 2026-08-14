class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (row in 0 until n) for (column in row + 1 until n) { val value = matrix[row][column]; matrix[row][column] = matrix[column][row]; matrix[column][row] = value }
        for (row in matrix) { var left = 0; var right = n - 1; while (left < right) { val value = row[left]; row[left++] = row[right]; row[right--] = value } }
    }
}
