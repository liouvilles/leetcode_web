class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val paths = IntArray(n) { 1 }
        for (row in 1 until m) {
            for (column in 1 until n) {
                paths[column] += paths[column - 1]
            }
        }
        return paths[n - 1]
    }
}
