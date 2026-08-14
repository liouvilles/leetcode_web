class Solution {
    fun moveZeroes(nums: IntArray) {
        var slow = 0
        for (fast in nums.indices) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast].also { nums[fast] = nums[slow] }
                slow++
            }
        }
    }
}
