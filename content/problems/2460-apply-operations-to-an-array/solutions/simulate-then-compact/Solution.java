class Solution {
    public int[] applyOperations(int[] nums){
        for(int i=0;i+1<nums.length;i++)if(nums[i]==nums[i+1]){
            nums[i]*=2;
            nums[i+1]=0;
        }
        int write=0;
        for(int value:nums)if(value!=0)nums[write++]=value;
        while(write<nums.length)nums[write++]=0;
        return nums;
    }
}
