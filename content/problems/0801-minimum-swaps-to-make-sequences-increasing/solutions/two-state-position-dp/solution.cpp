class Solution {
    public: int minSwap(vector<int>& nums1,vector<int>& nums2){
        int keep=0,swapped=1,infinity=1000000;
        for(int i=1;i<(int)nums1.size();++i){
            int nextKeep=infinity,nextSwap=infinity;
            if(nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                nextKeep=keep;
                nextSwap=swapped+1;
            }
            if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                nextKeep=min(nextKeep,swapped);
                nextSwap=min(nextSwap,keep+1);
            }
            keep=nextKeep;
            swapped=nextSwap;
        }
        return min(keep,swapped);
    }
};
