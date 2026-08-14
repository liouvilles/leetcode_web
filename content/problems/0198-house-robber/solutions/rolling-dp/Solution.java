class Solution {
    public int rob(int[] nums) {
        int beforePrevious = 0, previous = 0;
        for (int money : nums) {
            int current = Math.max(previous, beforePrevious + money);
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}
