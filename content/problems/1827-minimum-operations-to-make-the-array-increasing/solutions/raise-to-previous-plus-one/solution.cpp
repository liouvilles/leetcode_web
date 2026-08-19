class Solution {
    public: int minOperations(vector<int>& nums){
        int operations=0;
        for(int i=1;i<(int)nums.size();++i)if(nums[i]<=nums[i-1]){
            int target=nums[i-1]+1;
            operations+=target-nums[i];
            nums[i]=target;
        }
        return operations;
    }
};
