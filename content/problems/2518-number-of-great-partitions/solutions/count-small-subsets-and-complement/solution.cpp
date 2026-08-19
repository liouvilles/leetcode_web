class Solution {
    public:int countPartitions(vector<int>& nums,int k){
        const long long mod=1'000'000'007;
        long long sum=0,total=1;
        for(int value:nums){
            sum+=value;
            total=total*2%mod;
        }
        if(sum<2LL*k)return 0;
        vector<long long> dp(k);
        dp[0]=1;
        for(int value:nums)for(int current=k-1;current>=value;--current)dp[current]=(dp[current]+dp[current-value])%mod;
        long long bad=accumulate(dp.begin(),dp.end(),0LL)%mod;
        return (total-2*bad%mod+mod)%mod;
    }
};
