class Solution {
    fun numTrees(n: Int): Int { val dp = IntArray(n + 1); dp[0] = 1; for (nodes in 1..n) for (left in 0 until nodes) dp[nodes] += dp[left] * dp[nodes - 1 - left]; return dp[n] }
}
