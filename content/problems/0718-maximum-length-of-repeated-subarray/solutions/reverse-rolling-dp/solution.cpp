class Solution {
    public: int findLength(vector<int>& nums1,vector<int>& nums2){
        vector<int> dp(nums2.size()+1);
        int best=0;
        for(int value:nums1)for(int j=nums2.size();j>=1;--j){
            dp[j]=value==nums2[j-1]?dp[j-1]+1:0;
            best=max(best,dp[j]);
        }
        return best;
    }
};
