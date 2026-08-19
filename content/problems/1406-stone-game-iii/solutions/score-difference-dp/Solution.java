class Solution {
    public String stoneGameIII(int[] stoneValue){
        int n=stoneValue.length;
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            dp[i]=Integer.MIN_VALUE;
            int sum=0;
            for(int take=1;take<=3&&i+take<=n;take++){
                sum+=stoneValue[i+take-1];
                dp[i]=Math.max(dp[i],sum-dp[i+take]);
            }
        }
        return dp[0]>0?"Alice":dp[0]<0?"Bob":"Tie";
    }
}
