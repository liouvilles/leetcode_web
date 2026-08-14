class Solution {
    fun sortColors(nums: IntArray) {
        var left = 0; var middle = 0; var right = nums.lastIndex
        while (middle <= right) {
            when (nums[middle]) { 0 -> swap(nums, left++, middle++); 2 -> swap(nums, middle, right--); else -> middle++ }
        }
    }
    private fun swap(nums: IntArray, first: Int, second: Int) { val value = nums[first]; nums[first] = nums[second]; nums[second] = value }
}
