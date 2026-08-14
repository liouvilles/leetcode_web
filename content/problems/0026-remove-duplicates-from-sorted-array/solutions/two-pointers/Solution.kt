class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var length = 1
        for (index in 1 until nums.size) if (nums[index] != nums[length - 1]) nums[length++] = nums[index]
        return length
    }
}
