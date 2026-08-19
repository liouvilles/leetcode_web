class Solution {
    public int numRollsToTarget(int n,int k,int target){
        final int MOD=1000000007;
        long[] dp=new long[target+1];
        dp[0]=1;
        for(int dice=0;dice<n;dice++){
            long[] next=new long[target+1];
            for(int sum=1;sum<=target;sum++)for(int face=1;face<=k&&face<=sum;face++)next[sum]=(next[sum]+dp[sum-face])%MOD;
            dp=next;
        }
        return (int)dp[target];
    }
}
