class Solution {
    public long minOperationsToMakeMedianK(int[] nums,int k){
        Arrays.sort(nums);
        int middle=nums.length/2;
        long answer=0;
        for(int index=0;index<=middle;index++)if(nums[index]>k)answer+=(long)nums[index]-k;
        for(int index=middle;index<nums.length;index++)if(nums[index]<k)answer+=(long)k-nums[index];
        return answer;
    }
}
