class Solution {
    private boolean check(int[] nums,int skip){
        int previous=-1;
        for(int i=0;i<nums.length;i++)if(i!=skip){
            if(previous!=-1&&nums[previous]>=nums[i])return false;
            previous=i;
        }
        return true;
    }
    public boolean canBeIncreasing(int[] nums){
        for(int i=0;i+1<nums.length;i++)if(nums[i]>=nums[i+1])return check(nums,i)||check(nums,i+1);
        return true;
    }
}
