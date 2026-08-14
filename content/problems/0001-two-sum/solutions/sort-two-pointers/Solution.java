class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) pairs[i] = new int[] {nums[i], i};
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int left = 0, right = pairs.length - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            if (sum == target) return new int[] {pairs[left][1], pairs[right][1]};
            if (sum < target) left++; else right--;
        }
        return new int[0];
    }
}
