class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0], currentMin = nums[0], answer = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int value = nums[index];
            int previousMax = currentMax;
            currentMax = Math.max(value, Math.max(previousMax * value, currentMin * value));
            currentMin = Math.min(value, Math.min(previousMax * value, currentMin * value));
            answer = Math.max(answer, currentMax);
        }
        return answer;
    }
}
