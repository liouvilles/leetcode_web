class Solution {
    public:int longestMonotonicSubarray(vector<int>& nums){
        int increasing=1,decreasing=1,answer=1;
        for(int index=1;index<(int)nums.size();++index){
            if(nums[index]>nums[index-1]){
                ++increasing;
                decreasing=1;
            }else if(nums[index]<nums[index-1]){
                ++decreasing;
                increasing=1;
            }else increasing=decreasing=1;
            answer=max({
                answer,increasing,decreasing
            });
        }
        return answer;
    }
};
