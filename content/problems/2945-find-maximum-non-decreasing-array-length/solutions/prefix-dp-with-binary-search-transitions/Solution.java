class Solution {
    private int lowerBound(long[] values,long target){
        int left=0,right=values.length;
        while(left<right){
            int middle=(left+right)>>>1;
            if(values[middle]<target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    public int findMaximumLength(int[] nums){
        int n=nums.length;
        long[] prefix=new long[n+1];
        for(int i=0;i<n;i++)prefix[i+1]=prefix[i]+nums[i];
        int[] dp=new int[n+1],bestPrevious=new int[n+2];
        for(int end=1;end<=n;end++){
            bestPrevious[end]=Math.max(bestPrevious[end],bestPrevious[end-1]);
            int cut=bestPrevious[end];
            dp[end]=dp[cut]+1;
            long need=2L*prefix[end]-prefix[cut];
            int next=lowerBound(prefix,need);
            if(next<=n)bestPrevious[next]=Math.max(bestPrevious[next],end);
        }
        return dp[n];
    }
}
