class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); int best = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length - 2; first++) { int left = first + 1, right = nums.length - 1; while (left < right) { int sum = nums[first] + nums[left] + nums[right]; if (Math.abs((long)sum - target) < Math.abs((long)best - target)) best = sum; if (sum == target) return target; if (sum < target) left++; else right--; } }
        return best;
    }
}
