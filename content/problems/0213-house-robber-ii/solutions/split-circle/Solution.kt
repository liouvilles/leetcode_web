class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(linear(nums, 0, nums.size - 2), linear(nums, 1, nums.lastIndex))
    }
    private fun linear(nums: IntArray, start: Int, end: Int): Int { var before = 0; var previous = 0; for (index in start..end) { val current = maxOf(previous, before + nums[index]); before = previous; previous = current }; return previous }
}
