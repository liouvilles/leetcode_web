class Solution {
    fun rotate(nums: IntArray, shift: Int) {
        val k = shift % nums.size
        reverse(nums, 0, nums.lastIndex); reverse(nums, 0, k - 1); reverse(nums, k, nums.lastIndex)
    }
    private fun reverse(nums: IntArray, start: Int, end: Int) { var left = start; var right = end; while (left < right) { val value = nums[left]; nums[left++] = nums[right]; nums[right--] = value } }
}
