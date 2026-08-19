class Solution {
    public int minimumDeletions(int[] nums){
        int minimum=0,maximum=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[minimum])minimum=i;
            if(nums[i]>nums[maximum])maximum=i;
        }
        int first=Math.min(minimum,maximum),second=Math.max(minimum,maximum);
        return Math.min(second+1,Math.min(nums.length-first,first+1+nums.length-second));
    }
}
