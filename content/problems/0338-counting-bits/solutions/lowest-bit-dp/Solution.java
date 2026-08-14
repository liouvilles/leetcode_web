class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1]; for (int value = 1; value <= n; value++) bits[value] = bits[value >> 1] + (value & 1); return bits;
    }
}
