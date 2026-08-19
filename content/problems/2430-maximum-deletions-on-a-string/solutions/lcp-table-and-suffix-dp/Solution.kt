class Solution {
    fun deleteString(s:String):Int{
        val n=s.length;
        val lcp=Array(n+1){
            IntArray(n+1)
        };
        for(i in n-1 downTo 0)for(j in n-1 downTo i+1)if(s[i]==s[j])lcp[i][j]=lcp[i+1][j+1]+1;
        val dp=IntArray(n);
        for(i in n-1 downTo 0){
            dp[i]=1;
            var length=1;
            while(i+2*length<=n){
                if(lcp[i][i+length]>=length)dp[i]=maxOf(dp[i],1+dp[i+length]);
                length++
            }
        };
        return dp[0]
    }
}
