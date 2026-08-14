class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val unreachable = amount + 1
        val dp = IntArray(amount + 1) { unreachable }
        dp[0] = 0
        for (value in 1..amount) for (coin in coins) {
            if (coin <= value) dp[value] = minOf(dp[value], dp[value - coin] + 1)
        }
        return if (dp[amount] == unreachable) -1 else dp[amount]
    }
}
