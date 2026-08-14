class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length]; int size = 0;
        for (int value : nums) { int left = 0, right = size; while (left < right) { int middle = left + (right - left) / 2; if (tails[middle] < value) left = middle + 1; else right = middle; } tails[left] = value; if (left == size) size++; }
        return size;
    }
}
