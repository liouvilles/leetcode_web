class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, votes = 0;
        for (int value : nums) {
            if (votes == 0) candidate = value;
            votes += value == candidate ? 1 : -1;
        }
        return candidate;
    }
}
