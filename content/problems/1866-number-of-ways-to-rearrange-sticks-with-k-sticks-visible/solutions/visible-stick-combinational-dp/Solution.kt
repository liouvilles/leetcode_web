class Solution {
    fun rearrangeSticks(n:Int,k:Int):Int{
        val dp=Array(n+1){
            LongArray(k+1)
        };
        dp[0][0]=1;
        for(length in 1..n)for(visible in 1..minOf(length,k))dp[length][visible]=(dp[length-1][visible-1]+(length-1).toLong()*dp[length-1][visible])%1_000_000_007;
        return dp[n][k].toInt()
    }
}
