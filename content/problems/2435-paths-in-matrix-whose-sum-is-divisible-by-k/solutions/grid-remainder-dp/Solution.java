class Solution {
    public int numberOfPaths(int[][] grid,int k){
        int mod=1_000_000_007,rows=grid.length,columns=grid[0].length;
        int[][][] dp=new int[rows][columns][k];
        dp[0][0][grid[0][0]%k]=1;
        for(int r=0;r<rows;r++)for(int c=0;c<columns;c++)for(int remainder=0;remainder<k;remainder++){
            int ways=dp[r][c][remainder];
            if(r+1<rows){
                int next=(remainder+grid[r+1][c])%k;
                dp[r+1][c][next]=(dp[r+1][c][next]+ways)%mod;
            }
            if(c+1<columns){
                int next=(remainder+grid[r][c+1])%k;
                dp[r][c+1][next]=(dp[r][c+1][next]+ways)%mod;
            }
        }
        return dp[rows-1][columns-1][0];
    }
}
