class Solution {
    public: int waysToSplit(vector<int>& nums){
        const int MOD=1000000007;
        int n=nums.size();
        vector<long long> prefix(n+1);
        for(int i=0;i<n;++i)prefix[i+1]=prefix[i]+nums[i];
        long long answer=0;
        for(int first=1;first<=n-2;++first){
            auto begin=prefix.begin()+first+1,end=prefix.begin()+n;
            auto low=lower_bound(begin,end,2*prefix[first]);
            auto high=upper_bound(begin,end,(prefix[n]+prefix[first])/2);
            long long count=high-low;
            answer=(answer+max(0LL,count))%MOD;
        }
        return answer;
    }
};
