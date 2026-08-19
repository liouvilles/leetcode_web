class Solution {
    int[] nums,memo;
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    private int dfs(int mask){
        if(mask==(1<<nums.length)-1)return 0;
        if(memo[mask]>=0)return memo[mask];
        int operation=Integer.bitCount(mask)/2+1,best=0;
        for(int first=0;first<nums.length;first++)if((mask&(1<<first))==0)for(int second=first+1;second<nums.length;second++)if((mask&(1<<second))==0)best=Math.max(best,operation*gcd(nums[first],nums[second])+dfs(mask|(1<<first)|(1<<second)));
        return memo[mask]=best;
    }
    public int maxScore(int[] nums){
        this.nums=nums;
        memo=new int[1<<nums.length];
        Arrays.fill(memo,-1);
        return dfs(0);
    }
}
