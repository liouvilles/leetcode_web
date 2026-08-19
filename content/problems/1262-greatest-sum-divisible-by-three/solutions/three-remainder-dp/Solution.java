class Solution {
    public int maxSumDivThree(int[] nums){
        int negative=Integer.MIN_VALUE/4;
        int[] dp={
            0,negative,negative
        };
        for(int value:nums){
            int[] next=dp.clone();
            for(int remainder=0;remainder<3;remainder++)if(dp[remainder]>negative)next[(dp[remainder]+value)%3]=Math.max(next[(dp[remainder]+value)%3],dp[remainder]+value);
            dp=next;
        }
        return dp[0];
    }
}
