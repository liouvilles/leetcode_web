class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val middle = left + (right - left) / 2
            if (nums[middle] == target) return middle
            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target < nums[middle]) right = middle - 1
                else left = middle + 1
            } else {
                if (target > nums[middle] && target <= nums[right]) left = middle + 1
                else right = middle - 1
            }
        }
        return -1
    }
}
