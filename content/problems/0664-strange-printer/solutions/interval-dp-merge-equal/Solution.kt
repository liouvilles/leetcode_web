class Solution {
    fun strangePrinter(s:String):Int{
        val n=s.length;
        val dp=Array(n){
            IntArray(n)
        };
        for(i in n-1 downTo 0){
            dp[i][i]=1;
            for(j in i+1 until n){
                dp[i][j]=dp[i+1][j]+1;
                for(k in i+1..j)if(s[k]==s[i])dp[i][j]=minOf(dp[i][j],(if(k==i+1)0 else dp[i+1][k-1])+dp[k][j])
            }
        };
        return dp[0][n-1]
    }
}
