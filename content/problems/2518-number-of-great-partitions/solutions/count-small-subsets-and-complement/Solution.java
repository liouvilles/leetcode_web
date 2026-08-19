class Solution {
    public int countPartitions(int[] nums,int k){
        final long mod=1_000_000_007L;
        long sum=0,total=1;
        for(int value:nums){
            sum+=value;
            total=total*2%mod;
        }
        if(sum<2L*k)return 0;
        long[] dp=new long[k];
        dp[0]=1;
        for(int value:nums)for(int current=k-1;current>=value;current--)dp[current]=(dp[current]+dp[current-value])%mod;
        long bad=0;
        for(long ways:dp)bad=(bad+ways)%mod;
        return (int)((total-2*bad%mod+mod)%mod);
    }
}
