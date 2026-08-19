class Solution {
    public: int longestOnes(vector<int>& nums,int k){
        int left=0,zeros=0,answer=0;
        for(int right=0;right<(int)nums.size();++right){
            if(nums[right]==0)++zeros;
            while(zeros>k)if(nums[left++]==0)--zeros;
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
