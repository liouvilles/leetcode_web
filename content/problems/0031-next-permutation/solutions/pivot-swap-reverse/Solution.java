class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
        if (pivot >= 0) {
            int greater = nums.length - 1;
            while (nums[greater] <= nums[pivot]) greater--;
            swap(nums, pivot, greater);
        }
        for (int left = pivot + 1, right = nums.length - 1; left < right; left++, right--) swap(nums, left, right);
    }
    private void swap(int[] nums, int left, int right) { int value = nums[left]; nums[left] = nums[right]; nums[right] = value; }
}
