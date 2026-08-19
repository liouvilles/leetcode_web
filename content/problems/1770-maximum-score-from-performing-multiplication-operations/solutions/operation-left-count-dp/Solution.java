class Solution {
    private int[] nums,multipliers;
    private Integer[][] memo;
    private int dfs(int step,int left){
        if(step==multipliers.length)return 0;
        if(memo[step][left]!=null)return memo[step][left];
        int right=nums.length-1-(step-left);
        int takeLeft=nums[left]*multipliers[step]+dfs(step+1,left+1);
        int takeRight=nums[right]*multipliers[step]+dfs(step+1,left);
        return memo[step][left]=Math.max(takeLeft,takeRight);
    }
    public int maximumScore(int[] nums,int[] multipliers){
        this.nums=nums;
        this.multipliers=multipliers;
        memo=new Integer[multipliers.length][multipliers.length];
        return dfs(0,0);
    }
}
