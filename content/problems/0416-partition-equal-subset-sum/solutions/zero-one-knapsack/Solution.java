class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; for (int value : nums) sum += value; if ((sum & 1) == 1) return false;
        int target = sum / 2; boolean[] possible = new boolean[target + 1]; possible[0] = true;
        for (int value : nums) for (int current = target; current >= value; current--) possible[current] |= possible[current - value];
        return possible[target];
    }
}
