class Solution {
    fun moveZeroes(nums: IntArray) {
        var write = 0
        for (num in nums) if (num != 0) nums[write++] = num
        while (write < nums.size) nums[write++] = 0
    }
}
