class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if (first == nums.length || nums[first] != target) return new int[] {-1, -1};
        return new int[] {first, lowerBound(nums, target + 1L) - 1};
    }
    private int lowerBound(int[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) left = middle + 1; else right = middle;
        }
        return left;
    }
}
