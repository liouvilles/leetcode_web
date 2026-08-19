class Solution {
    public: vector<int> findErrorNums(vector<int>& nums){
        int duplicate=0,missing=0;
        for(int item:nums){
            int value=abs(item),index=value-1;
            if(nums[index]<0)duplicate=value;
            else nums[index]=-nums[index];
        }
        for(int i=0;i<(int)nums.size();++i)if(nums[i]>0)missing=i+1;
        return{
            duplicate,missing
        };
    }
};
