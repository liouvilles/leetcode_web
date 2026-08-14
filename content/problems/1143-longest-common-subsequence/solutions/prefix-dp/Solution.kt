class Solution {
    fun longestCommonSubsequence(first: String, second: String): Int {
        val length = Array(first.length + 1) { IntArray(second.length + 1) }
        for (i in 1..first.length) for (j in 1..second.length) length[i][j] = if (first[i - 1] == second[j - 1]) length[i - 1][j - 1] + 1 else maxOf(length[i - 1][j], length[i][j - 1])
        return length[first.length][second.length]
    }
}
