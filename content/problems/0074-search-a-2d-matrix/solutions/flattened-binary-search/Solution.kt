class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val columns = matrix[0].size
        var left = 0
        var right = matrix.size * columns - 1
        while (left <= right) { val middle = left + (right - left) / 2; val value = matrix[middle / columns][middle % columns]; if (value == target) return true; if (value < target) left = middle + 1 else right = middle - 1 }
        return false
    }
}
