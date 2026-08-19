class Solution {
    public long maxArrayValue(int[] nums){
        long current=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)current=nums[i]<=current?current+nums[i]:nums[i];
        return current;
    }
}
