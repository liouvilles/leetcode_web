class Solution {
    fun minSpaceWastedKResizing(nums:IntArray,k:Int):Int{
        val n=nums.size;
        val waste=Array(n){
            IntArray(n)
        };
        for(left in 0 until n){
            var maximum=0;
            var sum=0;
            for(right in left until n){
                maximum=maxOf(maximum,nums[right]);
                sum+=nums[right];
                waste[left][right]=maximum*(right-left+1)-sum
            }
        };
        val infinity=1_000_000_000;
        val dp=Array(k+2){
            IntArray(n+1){
                infinity
            }
        };
        dp[0][0]=0;
        for(groups in 1..k+1)for(end in 1..n)for(start in 0 until end)if(dp[groups-1][start]<infinity)dp[groups][end]=minOf(dp[groups][end],dp[groups-1][start]+waste[start][end-1]);
        return (1..k+1).minOf{
            dp[it][n]
        }
    }
}
