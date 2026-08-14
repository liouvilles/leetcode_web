class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0; var column = matrix[0].lastIndex
        while (row < matrix.size && column >= 0) { val value = matrix[row][column]; if (value == target) return true; if (value > target) column-- else row++ }
        return false
    }
}
