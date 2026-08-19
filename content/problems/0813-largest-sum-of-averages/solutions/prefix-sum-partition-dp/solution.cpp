class Solution {
    public: double largestSumOfAverages(vector<int>& nums,int k){
        int n=nums.size();
        vector<double> prefix(n+1),dp(n+1);
        for(int i=0;i<n;++i)prefix[i+1]=prefix[i]+nums[i];
        for(int i=1;i<=n;++i)dp[i]=prefix[i]/i;
        for(int group=2;group<=k;++group){
            vector<double> next(n+1);
            for(int i=group;i<=n;++i)for(int cut=group-1;cut<i;++cut)next[i]=max(next[i],dp[cut]+(prefix[i]-prefix[cut])/(i-cut));
            dp.swap(next);
        }
        return dp[n];
    }
};
