class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(linear(nums, 0, nums.length - 2), linear(nums, 1, nums.length - 1));
    }
    private int linear(int[] nums, int start, int end) { int before = 0, previous = 0; for (int index = start; index <= end; index++) { int current = Math.max(previous, before + nums[index]); before = previous; previous = current; } return previous; }
}
