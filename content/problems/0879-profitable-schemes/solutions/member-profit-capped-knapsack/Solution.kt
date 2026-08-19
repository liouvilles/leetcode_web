class Solution {
    fun profitableSchemes(n:Int,minProfit:Int,group:IntArray,profit:IntArray):Int{
        val mod=1000000007L;
        val dp=Array(n+1){
            LongArray(minProfit+1)
        };
        dp[0][0]=1;
        for(job in group.indices)for(members in n-group[job] downTo 0)for(earned in minProfit downTo 0){
            val next=minOf(minProfit,earned+profit[job]);
            dp[members+group[job]][next]=(dp[members+group[job]][next]+dp[members][earned])%mod
        };
        var answer=0L;
        for(members in 0..n)answer=(answer+dp[members][minProfit])%mod;
        return answer.toInt()
    }
}
