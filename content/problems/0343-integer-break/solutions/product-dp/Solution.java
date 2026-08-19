class Solution {
    public int integerBreak(int n){
        int[] dp=new int[n+1];
        for(int value=2;value<=n;value++)for(int first=1;first<value;first++)dp[value]=Math.max(dp[value],first*Math.max(value-first,dp[value-first]));
        return dp[n];
    }
}
