class Solution {
    public: bool check(vector<int>& nums){
        int drops=0;
        for(int i=0;i<(int)nums.size();++i)drops+=nums[i]>nums[(i+1)%nums.size()];
        return drops<=1;
    }
};
