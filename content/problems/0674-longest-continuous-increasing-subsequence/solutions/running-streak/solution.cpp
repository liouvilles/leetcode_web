class Solution {
    public: int findLengthOfLCIS(vector<int>& nums){
        int current=1,best=1;
        for(int i=1;i<(int)nums.size();++i){
            current=nums[i]>nums[i-1]?current+1:1;
            best=max(best,current);
        }
        return best;
    }
};
