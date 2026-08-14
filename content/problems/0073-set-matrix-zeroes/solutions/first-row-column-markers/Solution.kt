class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var firstRowZero = matrix[0].any { it == 0 }
        var firstColumnZero = matrix.any { it[0] == 0 }
        for (row in 1 until matrix.size) for (column in 1 until matrix[0].size) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0 }
        for (row in 1 until matrix.size) for (column in 1 until matrix[0].size) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0
        if (firstRowZero) matrix[0].fill(0)
        if (firstColumnZero) for (row in matrix) row[0] = 0
    }
}
