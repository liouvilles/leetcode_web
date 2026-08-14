class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val memo = IntArray(amount + 1) { -2 }
        memo[0] = 0
        fun dfs(remain: Int): Int {
            if (remain < 0) return -1
            if (memo[remain] != -2) return memo[remain]
            var best = Int.MAX_VALUE
            for (coin in coins) {
                val sub = dfs(remain - coin)
                if (sub >= 0) best = minOf(best, sub + 1)
            }
            memo[remain] = if (best == Int.MAX_VALUE) -1 else best
            return memo[remain]
        }
        return dfs(amount)
    }
}
