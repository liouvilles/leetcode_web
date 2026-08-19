class Solution {
    private int dfs(int[] nums,int index,int value){
        if(index==nums.length)return value;
        return dfs(nums,index+1,value)+dfs(nums,index+1,value^nums[index]);
    }
    public int subsetXORSum(int[] nums){
        return dfs(nums,0,0);
    }
}
