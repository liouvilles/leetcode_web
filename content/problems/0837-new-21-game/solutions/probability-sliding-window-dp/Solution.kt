class Solution {
    fun new21Game(n:Int,k:Int,maxPts:Int):Double{
        if(k==0||n>=k-1+maxPts)return 1.0;
        val dp=DoubleArray(n+1);
        dp[0]=1.0;
        var window=1.0;
        var answer=0.0;
        for(score in 1..n){
            dp[score]=window/maxPts;
            if(score<k)window+=dp[score] else answer+=dp[score];
            val expired=score-maxPts;
            if(expired>=0&&expired<k)window-=dp[expired]
        };
        return answer
    }
}
