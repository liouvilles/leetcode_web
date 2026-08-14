class Solution {
    public int minimumTotal(List<List<Integer>> triangle) { int[] dp = new int[triangle.size() + 1]; for (int row = triangle.size() - 1; row >= 0; row--) for (int column = 0; column <= row; column++) dp[column] = triangle.get(row).get(column) + Math.min(dp[column], dp[column + 1]); return dp[0]; }
}
