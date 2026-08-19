class Solution {
    public long sellingWood(int m,int n,int[][] prices){
        long[][] dp=new long[m+1][n+1];
        for(int[] price:prices)dp[price[0]][price[1]]=Math.max(dp[price[0]][price[1]],price[2]);
        for(int h=1;h<=m;h++)for(int w=1;w<=n;w++){
            for(int cut=1;cut<h;cut++)dp[h][w]=Math.max(dp[h][w],dp[cut][w]+dp[h-cut][w]);
            for(int cut=1;cut<w;cut++)dp[h][w]=Math.max(dp[h][w],dp[h][cut]+dp[h][w-cut]);
        }
        return dp[m][n];
    }
}
