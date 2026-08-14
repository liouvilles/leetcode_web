class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0; var right = nums.lastIndex
        while (left <= right) { val middle = left + (right - left) / 2; if (nums[middle] == target) return true; if (nums[left] == nums[middle] && nums[middle] == nums[right]) { left++; right-- } else if (nums[left] <= nums[middle]) { if (nums[left] <= target && target < nums[middle]) right = middle - 1 else left = middle + 1 } else { if (nums[middle] < target && target <= nums[right]) left = middle + 1 else right = middle - 1 } }
        return false
    }
}
