class Solution {
    public: bool isMonotonic(vector<int>& nums){
        bool increasing=false,decreasing=false;
        for(int i=1;i<(int)nums.size();++i){
            increasing|=nums[i]>nums[i-1];
            decreasing|=nums[i]<nums[i-1];
            if(increasing&&decreasing)return false;
        }
        return true;
    }
};
