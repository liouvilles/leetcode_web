class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val answer = ArrayList<Int>()
        var top = 0; var bottom = matrix.lastIndex; var left = 0; var right = matrix[0].lastIndex
        while (top <= bottom && left <= right) {
            for (column in left..right) answer.add(matrix[top][column]); top++
            for (row in top..bottom) answer.add(matrix[row][right]); right--
            if (top <= bottom) { for (column in right downTo left) answer.add(matrix[bottom][column]); bottom-- }
            if (left <= right) { for (row in bottom downTo top) answer.add(matrix[row][left]); left++ }
        }
        return answer
    }
}
