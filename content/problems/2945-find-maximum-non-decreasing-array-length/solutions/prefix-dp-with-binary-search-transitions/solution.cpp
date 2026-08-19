class Solution {
    public:int findMaximumLength(vector<int>& nums){
        int n=nums.size();
        vector<long long> prefix(n+1);
        for(int i=0;i<n;++i)prefix[i+1]=prefix[i]+nums[i];
        vector<int> dp(n+1),bestPrevious(n+2);
        for(int end=1;end<=n;++end){
            bestPrevious[end]=max(bestPrevious[end],bestPrevious[end-1]);
            int cut=bestPrevious[end];
            dp[end]=dp[cut]+1;
            long long need=2*prefix[end]-prefix[cut];
            auto position=lower_bound(prefix.begin(),prefix.end(),need);
            if(position!=prefix.end()){
                int next=position-prefix.begin();
                bestPrevious[next]=max(bestPrevious[next],end);
            }
        }
        return dp[n];
    }
};
