class Solution {
    fun nextPermutation(nums: IntArray) {
        var pivot = nums.size - 2
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--
        if (pivot >= 0) {
            var greater = nums.lastIndex
            while (nums[greater] <= nums[pivot]) greater--
            swap(nums, pivot, greater)
        }
        var left = pivot + 1
        var right = nums.lastIndex
        while (left < right) swap(nums, left++, right--)
    }
    private fun swap(nums: IntArray, left: Int, right: Int) { val value = nums[left]; nums[left] = nums[right]; nums[right] = value }
}
