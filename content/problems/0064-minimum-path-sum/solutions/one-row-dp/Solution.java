class Solution {
    public int minPathSum(int[][] grid) {
        int[] cost = new int[grid[0].length];
        cost[0] = grid[0][0];
        for (int column = 1; column < cost.length; column++) cost[column] = cost[column - 1] + grid[0][column];
        for (int row = 1; row < grid.length; row++) {
            cost[0] += grid[row][0];
            for (int column = 1; column < cost.length; column++) cost[column] = Math.min(cost[column], cost[column - 1]) + grid[row][column];
        }
        return cost[cost.length - 1];
    }
}
