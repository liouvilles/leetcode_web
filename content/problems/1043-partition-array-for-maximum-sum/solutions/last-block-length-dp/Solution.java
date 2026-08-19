class Solution {
    public int maxSumAfterPartitioning(int[] arr,int k){
        int[] dp=new int[arr.length+1];
        for(int i=1;i<=arr.length;i++){
            int maximum=0;
            for(int length=1;length<=Math.min(k,i);length++){
                maximum=Math.max(maximum,arr[i-length]);
                dp[i]=Math.max(dp[i],dp[i-length]+maximum*length);
            }
        }
        return dp[arr.length];
    }
}
