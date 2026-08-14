class Solution {
    public int uniquePaths(int m, int n) {
        int[] paths = new int[n];
        Arrays.fill(paths, 1);
        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                paths[column] += paths[column - 1];
            }
        }
        return paths[n - 1];
    }
}
