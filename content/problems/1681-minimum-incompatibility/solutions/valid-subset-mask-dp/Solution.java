class Solution {
    public int minimumIncompatibility(int[] nums,int k){
        int n=nums.length,group=n/k,total=1<<n,inf=1_000_000;
        int[] cost=new int[total];
        Arrays.fill(cost,-1);
        for(int mask=0;mask<total;mask++)if(Integer.bitCount(mask)==group){
            int seen=0,minimum=Integer.MAX_VALUE,maximum=0;
            boolean valid=true;
            for(int i=0;i<n;i++)if((mask&(1<<i))!=0){
                int bit=1<<(nums[i]-1);
                if((seen&bit)!=0){
                    valid=false;
                    break;
                }
                seen|=bit;
                minimum=Math.min(minimum,nums[i]);
                maximum=Math.max(maximum,nums[i]);
            }
            if(valid)cost[mask]=maximum-minimum;
        }
        int[] dp=new int[total];
        Arrays.fill(dp,inf);
        dp[0]=0;
        for(int mask=0;mask<total;mask++)if(dp[mask]<inf){
            int remaining=(total-1)^mask;
            if(remaining==0)continue;
            int first=remaining&-remaining;
            for(int subset=remaining;subset>0;subset=(subset-1)&remaining)if((subset&first)!=0&&cost[subset]>=0)dp[mask|subset]=Math.min(dp[mask|subset],dp[mask]+cost[subset]);
        }
        return dp[total-1]>=inf?-1:dp[total-1];
    }
}
