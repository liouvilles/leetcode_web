class Solution {
    public: int numRollsToTarget(int n,int k,int target){
        const int MOD=1000000007;
        vector<long long> dp(target+1);
        dp[0]=1;
        while(n--){
            vector<long long> next(target+1);
            for(int sum=1;sum<=target;++sum)for(int face=1;face<=k&&face<=sum;++face)next[sum]=(next[sum]+dp[sum-face])%MOD;
            dp.swap(next);
        }
        return dp[target];
    }
};
