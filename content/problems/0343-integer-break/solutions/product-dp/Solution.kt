class Solution {
    fun integerBreak(n:Int):Int{
        val dp=IntArray(n+1);
        for(value in 2..n)for(first in 1 until value)dp[value]=maxOf(dp[value],first*maxOf(value-first,dp[value-first]));
        return dp[n]
    }
}
