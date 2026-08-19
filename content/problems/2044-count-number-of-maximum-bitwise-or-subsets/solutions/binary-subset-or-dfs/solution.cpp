class Solution {
    int target=0;
    int dfs(vector<int>& nums,int index,int value){
        if(index==(int)nums.size())return value==target;
        return dfs(nums,index+1,value)+dfs(nums,index+1,value|nums[index]);
    }
    public: int countMaxOrSubsets(vector<int>& nums){
        for(int value:nums)target|=value;
        return dfs(nums,0,0);
    }
};
