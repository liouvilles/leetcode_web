class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val answer = Array(n) { IntArray(n) }; var top = 0; var bottom = n - 1; var left = 0; var right = n - 1; var value = 1
        while (top <= bottom && left <= right) { for (column in left..right) answer[top][column] = value++; top++; for (row in top..bottom) answer[row][right] = value++; right--; if (top <= bottom) { for (column in right downTo left) answer[bottom][column] = value++; bottom-- }; if (left <= right) { for (row in bottom downTo top) answer[row][left] = value++; left++ } }
        return answer
    }
}
