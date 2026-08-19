class Solution {
    public int maximumJumps(int[] nums,int target){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int end=1;end<nums.length;end++)for(int start=0;start<end;start++)if(dp[start]>=0&&Math.abs((long)nums[end]-nums[start])<=target)dp[end]=Math.max(dp[end],dp[start]+1);
        return dp[nums.length-1];
    }
}
