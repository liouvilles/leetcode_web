class Solution {
    public:int minimumTime(vector<int>& nums1,vector<int>& nums2,int x){
        int n=nums1.size();
        vector<pair<int,int>> pairs;
        long long base=0,growth=0;
        for(int i=0;i<n;++i){
            pairs.push_back({
                nums2[i],nums1[i]
            });
            base+=nums1[i];
            growth+=nums2[i];
        }
        sort(pairs.begin(),pairs.end());
        vector<long long> dp(n+1);
        for(int i=0;i<n;++i)for(int selected=i+1;selected>=1;--selected)dp[selected]=max(dp[selected],dp[selected-1]+pairs[i].second+1LL*pairs[i].first*selected);
        for(int seconds=0;seconds<=n;++seconds)if(base+growth*seconds-dp[seconds]<=x)return seconds;
        return -1;
    }
};
