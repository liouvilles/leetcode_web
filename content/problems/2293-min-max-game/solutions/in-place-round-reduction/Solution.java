class Solution {
    public int minMaxGame(int[] nums){
        for(int length=nums.length;length>1;length/=2)for(int i=0;i<length/2;i++)nums[i]=i%2==0?Math.min(nums[2*i],nums[2*i+1]):Math.max(nums[2*i],nums[2*i+1]);
        return nums[0];
    }
}
