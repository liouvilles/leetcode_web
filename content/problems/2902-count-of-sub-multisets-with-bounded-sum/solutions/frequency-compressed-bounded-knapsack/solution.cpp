class Solution {
    public:int countSubMultisets(vector<int>& nums,int l,int r){
        const int MOD=1000000007;
        unordered_map<int,int> count;
        for(int value:nums)++count[value];
        vector<int> dp(r+1);
        dp[0]=count[0]+1;
        for(auto [value,copies]:count){
            if(!value)continue;
            vector<int> next(r+1);
            long long removedDistance=1LL*(copies+1)*value;
            for(int sum=0;sum<=r;++sum){
                long long ways=dp[sum];
                if(sum>=value)ways+=next[sum-value];
                if(sum>=removedDistance)ways-=dp[sum-removedDistance];
                ways%=MOD;
                if(ways<0)ways+=MOD;
                next[sum]=ways;
            }
            dp.swap(next);
        }
        long long answer=0;
        for(int sum=l;sum<=r;++sum)answer+=dp[sum];
        return answer%MOD;
    }
};
