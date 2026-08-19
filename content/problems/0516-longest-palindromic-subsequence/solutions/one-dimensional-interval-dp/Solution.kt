class Solution {
    fun longestPalindromeSubseq(s:String):Int{
        val dp=IntArray(s.length);
        for(i in s.lastIndex downTo 0){
            dp[i]=1;
            var previous=0;
            for(j in i+1 until s.length){
                val old=dp[j];
                dp[j]=if(s[i]==s[j])previous+2 else maxOf(dp[j],dp[j-1]);
                previous=old
            }
        };
        return dp.last()
    }
}
