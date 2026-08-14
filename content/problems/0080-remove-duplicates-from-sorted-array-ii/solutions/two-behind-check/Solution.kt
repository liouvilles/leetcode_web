class Solution {
    fun removeDuplicates(nums: IntArray): Int { var write = 0; for (value in nums) if (write < 2 || value != nums[write - 2]) nums[write++] = value; return write }
}
