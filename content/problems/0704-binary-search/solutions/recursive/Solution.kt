class Solution {
    fun search(nums: IntArray, target: Int): Int =
        search(nums, target, 0, nums.lastIndex)

    private fun search(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) return -1
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        return if (nums[mid] < target) search(nums, target, mid + 1, right)
        else search(nums, target, left, mid - 1)
    }
}
