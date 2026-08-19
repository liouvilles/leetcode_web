class Solution {
    private int solve(int[] nums,int target){
        int n=nums.length;
        int[][] dp=new int[n][n];
        for(int length=2;length<=n;length++){
            for(int left=0;left+length<=n;left++){
                int right=left+length-1,best=0;
                if(nums[left]+nums[left+1]==target)best=Math.max(best,1+(length==2?0:dp[left+2][right]));
                if(nums[right-1]+nums[right]==target)best=Math.max(best,1+(length==2?0:dp[left][right-2]));
                if(nums[left]+nums[right]==target)best=Math.max(best,1+(length==2?0:dp[left+1][right-1]));
                dp[left][right]=best;
            }
        }
        return dp[0][n-1];
    }
    public int maxOperations(int[] nums){
        int n=nums.length;
        int answer=solve(nums,nums[0]+nums[1]);
        answer=Math.max(answer,solve(nums,nums[n-2]+nums[n-1]));
        return Math.max(answer,solve(nums,nums[0]+nums[n-1]));
    }
}
