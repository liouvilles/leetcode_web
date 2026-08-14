class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        var best = dp[0]
        for (i in 1 until nums.size) {
            dp[i] = maxOf(nums[i], dp[i - 1] + nums[i])
            best = maxOf(best, dp[i])
        }
        return best
    }
}
