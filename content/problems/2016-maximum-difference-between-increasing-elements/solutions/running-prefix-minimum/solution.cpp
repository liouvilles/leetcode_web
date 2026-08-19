class Solution {
    public: int maximumDifference(vector<int>& nums){
        int minimum=nums[0],answer=-1;
        for(int i=1;i<(int)nums.size();++i){
            if(nums[i]>minimum)answer=max(answer,nums[i]-minimum);
            minimum=min(minimum,nums[i]);
        }
        return answer;
    }
};
