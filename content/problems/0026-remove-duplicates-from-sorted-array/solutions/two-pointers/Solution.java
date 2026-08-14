class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != nums[length - 1]) nums[length++] = nums[index];
        }
        return length;
    }
}
