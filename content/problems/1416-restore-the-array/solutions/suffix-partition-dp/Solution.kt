class Solution {
    fun numberOfArrays(text:String,k:Int):Int{
        val n=text.length;
        val mod=1_000_000_007;
        val dp=IntArray(n+1);
        dp[n]=1;
        for(i in n-1 downTo 0){
            if(text[i]=='0')continue;
            var value=0L;
            for(j in i until n){
                value=value*10+(text[j]-'0');
                if(value>k)break;
                dp[i]=(dp[i]+dp[j+1])%mod
            }
        };
        return dp[0]
    }
}
