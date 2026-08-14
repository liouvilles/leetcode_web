class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0; var sum = 0; var best = Int.MAX_VALUE
        for (right in nums.indices) { sum += nums[right]; while (sum >= target) { best = minOf(best, right - left + 1); sum -= nums[left++] } }
        return if (best == Int.MAX_VALUE) 0 else best
    }
}
