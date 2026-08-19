class Solution {
    public:int sumOfPower(vector<int>& nums,int k){
        const long long mod=1000000007;
        vector<long long> dp(k+1);
        dp[0]=1;
        for(int value:nums){
            for(int sum=k;sum>=0;--sum){
                dp[sum]=dp[sum]*2%mod;
                if(sum>=value)dp[sum]=(dp[sum]+dp[sum-value])%mod;
            }
        }
        return dp[k];
    }
};
