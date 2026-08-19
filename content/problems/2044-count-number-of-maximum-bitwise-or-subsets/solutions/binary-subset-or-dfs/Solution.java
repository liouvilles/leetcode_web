class Solution {
    int target;
    private int dfs(int[] nums,int index,int value){
        if(index==nums.length)return value==target?1:0;
        return dfs(nums,index+1,value)+dfs(nums,index+1,value|nums[index]);
    }
    public int countMaxOrSubsets(int[] nums){
        for(int value:nums)target|=value;
        return dfs(nums,0,0);
    }
}
