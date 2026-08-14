class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var current = nums[0]
        var best = nums[0]
        for (i in 1 until nums.size) {
            current = maxOf(nums[i], current + nums[i])
            best = maxOf(best, current)
        }
        return best
    }
}
