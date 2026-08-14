class Solution {
    public int findMin(int[] nums) { int left = 0, right = nums.length - 1; while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else if (nums[middle] < nums[right]) right = middle; else right--; } return nums[left]; }
}
