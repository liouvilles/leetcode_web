class Solution {
    public int countGoodStrings(int low,int high,int zero,int one){
        int mod=1_000_000_007;
        long[] dp=new long[high+1];
        dp[0]=1;
        for(int length=0;length<=high;length++){
            if(length+zero<=high)dp[length+zero]=(dp[length+zero]+dp[length])%mod;
            if(length+one<=high)dp[length+one]=(dp[length+one]+dp[length])%mod;
        }
        long answer=0;
        for(int length=low;length<=high;length++)answer=(answer+dp[length])%mod;
        return (int)answer;
    }
}
