class Solution {
    public int minFallingPathSum(int[][] grid){
        int n=grid.length;
        if(n==1)return grid[0][0];
        int[] dp=grid[0].clone();
        for(int row=1;row<n;row++){
            int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE,firstColumn=-1;
            for(int column=0;column<n;column++)if(dp[column]<first){
                second=first;
                first=dp[column];
                firstColumn=column;
            }else if(dp[column]<second)second=dp[column];
            int[] next=new int[n];
            for(int column=0;column<n;column++)next[column]=grid[row][column]+(column==firstColumn?second:first);
            dp=next;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
