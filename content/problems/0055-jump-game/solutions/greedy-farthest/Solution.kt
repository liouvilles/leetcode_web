class Solution {
    fun canJump(nums: IntArray): Boolean {
        var farthest = 0
        for (index in nums.indices) {
            if (index > farthest) return false
            farthest = maxOf(farthest, index + nums[index])
            if (farthest >= nums.lastIndex) return true
        }
        return true
    }
}
