class Solution {
    fun minInsertions(s:String):Int{
        val reverse=s.reversed();
        val n=s.length;
        var dp=IntArray(n+1);
        for(i in 1..n){
            val next=IntArray(n+1);
            for(j in 1..n)next[j]=if(s[i-1]==reverse[j-1])dp[j-1]+1 else maxOf(dp[j],next[j-1]);
            dp=next
        };
        return n-dp[n]
    }
}
