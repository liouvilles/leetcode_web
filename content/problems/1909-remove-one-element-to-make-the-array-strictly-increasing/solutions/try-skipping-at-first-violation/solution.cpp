class Solution {
    bool check(vector<int>& nums,int skip){
        int previous=-1;
        for(int i=0;i<(int)nums.size();++i)if(i!=skip){
            if(previous!=-1&&nums[previous]>=nums[i])return false;
            previous=i;
        }
        return true;
    }
    public: bool canBeIncreasing(vector<int>& nums){
        for(int i=0;i+1<(int)nums.size();++i)if(nums[i]>=nums[i+1])return check(nums,i)||check(nums,i+1);
        return true;
    }
};
