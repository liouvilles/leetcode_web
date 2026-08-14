class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        return nums[mid] < target
            ? search(nums, target, mid + 1, right)
            : search(nums, target, left, mid - 1);
    }
}
