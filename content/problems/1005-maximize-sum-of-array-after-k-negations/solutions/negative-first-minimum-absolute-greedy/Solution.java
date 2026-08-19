class Solution {
    public int largestSumAfterKNegations(int[] nums,int k){
        Arrays.sort(nums);
        for(int i=0;i<nums.length&&k>0&&nums[i]<0;i++,k--)nums[i]=-nums[i];
        int sum=0,minimum=Integer.MAX_VALUE;
        for(int value:nums){
            sum+=value;
            minimum=Math.min(minimum,Math.abs(value));
        }
        return k%2==0?sum:sum-2*minimum;
    }
}
