class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length]; answer[0] = 1;
        for (int index = 1; index < nums.length; index++) answer[index] = answer[index - 1] * nums[index - 1];
        int suffix = 1;
        for (int index = nums.length - 1; index >= 0; index--) { answer[index] *= suffix; suffix *= nums[index]; }
        return answer;
    }
}
