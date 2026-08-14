class Solution {
    public int longestCommonSubsequence(String first, String second) {
        int[][] length = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) for (int j = 1; j <= second.length(); j++) length[i][j] = first.charAt(i - 1) == second.charAt(j - 1) ? length[i - 1][j - 1] + 1 : Math.max(length[i - 1][j], length[i][j - 1]);
        return length[first.length()][second.length()];
    }
}
