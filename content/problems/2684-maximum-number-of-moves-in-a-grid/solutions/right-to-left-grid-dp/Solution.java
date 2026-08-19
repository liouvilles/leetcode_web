class Solution {
    public int maxMoves(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        int[][] dp=new int[rows][cols];
        for(int col=cols-2;col>=0;col--)for(int row=0;row<rows;row++)for(int nextRow=Math.max(0,row-1);nextRow<=Math.min(rows-1,row+1);nextRow++)if(grid[nextRow][col+1]>grid[row][col])dp[row][col]=Math.max(dp[row][col],1+dp[nextRow][col+1]);
        int answer=0;
        for(int row=0;row<rows;row++)answer=Math.max(answer,dp[row][0]);
        return answer;
    }
}
