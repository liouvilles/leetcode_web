class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            farthest = Math.max(farthest, index + nums[index]);
            if (index == currentEnd) { jumps++; currentEnd = farthest; }
        }
        return jumps;
    }
}
