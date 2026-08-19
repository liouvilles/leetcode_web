class Solution {
    fun paintWalls(cost:IntArray,time:IntArray):Int{
        val n=cost.size;
        val inf=1000000000;
        val dp=IntArray(n+1){
            inf
        };
        dp[0]=0;
        for(i in 0 until n)for(covered in n-1 downTo 0)if(dp[covered]<inf){
            val next=minOf(n,covered+time[i]+1);
            dp[next]=minOf(dp[next],dp[covered]+cost[i])
        };
        return dp[n]
    }
}
