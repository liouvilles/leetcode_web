class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1 else right = middle }
        return left
    }
}
