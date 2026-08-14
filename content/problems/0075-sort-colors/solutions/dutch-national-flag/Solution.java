class Solution {
    public void sortColors(int[] nums) {
        int left = 0, middle = 0, right = nums.length - 1;
        while (middle <= right) {
            if (nums[middle] == 0) { swap(nums, left++, middle++); }
            else if (nums[middle] == 2) { swap(nums, middle, right--); }
            else middle++;
        }
    }
    private void swap(int[] nums, int first, int second) { int value = nums[first]; nums[first] = nums[second]; nums[second] = value; }
}
