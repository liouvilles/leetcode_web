class Solution {
    public: int longestSubarray(vector<int>& nums){
        int left=0,zeros=0,answer=0;
        for(int right=0;right<(int)nums.size();++right){
            if(!nums[right])++zeros;
            while(zeros>1)if(!nums[left++])--zeros;
            answer=max(answer,right-left);
        }
        return answer;
    }
};
