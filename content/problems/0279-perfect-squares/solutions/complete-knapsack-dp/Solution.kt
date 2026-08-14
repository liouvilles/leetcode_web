class Solution {
    fun numSquares(n: Int): Int {
        val count = IntArray(n + 1) { n + 1 }; count[0] = 0
        for (value in 1..n) { var root = 1; while (root * root <= value) { count[value] = minOf(count[value], count[value - root * root] + 1); root++ } }
        return count[n]
    }
}
