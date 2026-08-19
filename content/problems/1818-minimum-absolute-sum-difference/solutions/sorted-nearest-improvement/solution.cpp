class Solution {
    public: int minAbsoluteSumDiff(vector<int>& nums1,vector<int>& nums2){
        auto sorted=nums1;
        sort(sorted.begin(),sorted.end());
        long long total=0;
        int bestGain=0;
        for(int i=0;i<(int)nums1.size();++i){
            int original=abs(nums1[i]-nums2[i]);
            total+=original;
            auto it=lower_bound(sorted.begin(),sorted.end(),nums2[i]);
            int closest=INT_MAX;
            if(it!=sorted.end())closest=min(closest,abs(*it-nums2[i]));
            if(it!=sorted.begin())closest=min(closest,abs(*prev(it)-nums2[i]));
            bestGain=max(bestGain,original-closest);
        }
        return (total-bestGain)%1000000007;
    }
};
