class Solution {
    public:int maxNonDecreasingLength(vector<int>& nums1,vector<int>& nums2){
        int endingFirst=1,endingSecond=1,answer=1;
        for(int i=1;i<(int)nums1.size();++i){
            int nextFirst=1,nextSecond=1;
            if(nums1[i]>=nums1[i-1])nextFirst=max(nextFirst,endingFirst+1);
            if(nums1[i]>=nums2[i-1])nextFirst=max(nextFirst,endingSecond+1);
            if(nums2[i]>=nums1[i-1])nextSecond=max(nextSecond,endingFirst+1);
            if(nums2[i]>=nums2[i-1])nextSecond=max(nextSecond,endingSecond+1);
            endingFirst=nextFirst;
            endingSecond=nextSecond;
            answer=max({
                answer,endingFirst,endingSecond
            });
        }
        return answer;
    }
};
