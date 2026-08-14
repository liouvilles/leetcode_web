class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0; var right = nums.lastIndex
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] < nums[middle + 1]) left = middle + 1 else right = middle }
        return left
    }
}
