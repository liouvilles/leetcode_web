class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = lowerBound(nums, target.toLong())
        if (first == nums.size || nums[first] != target) return intArrayOf(-1, -1)
        return intArrayOf(first, lowerBound(nums, target.toLong() + 1) - 1)
    }
    private fun lowerBound(nums: IntArray, target: Long): Int {
        var left = 0
        var right = nums.size
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle].toLong() < target) left = middle + 1 else right = middle }
        return left
    }
}
