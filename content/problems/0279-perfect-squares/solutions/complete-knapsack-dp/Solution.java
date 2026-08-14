class Solution {
    public int numSquares(int n) {
        int[] count = new int[n + 1]; Arrays.fill(count, n + 1); count[0] = 0;
        for (int value = 1; value <= n; value++) for (int root = 1; root * root <= value; root++) count[value] = Math.min(count[value], count[value - root * root] + 1);
        return count[n];
    }
}
