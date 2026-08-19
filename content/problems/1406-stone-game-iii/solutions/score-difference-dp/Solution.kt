class Solution {
    fun stoneGameIII(stoneValue:IntArray):String{
        val n=stoneValue.size;
        val dp=IntArray(n+1);
        for(i in n-1 downTo 0){
            dp[i]=Int.MIN_VALUE;
            var sum=0;
            for(take in 1..3)if(i+take<=n){
                sum+=stoneValue[i+take-1];
                dp[i]=maxOf(dp[i],sum-dp[i+take])
            }
        };
        return if(dp[0]>0)"Alice" else if(dp[0]<0)"Bob" else "Tie"
    }
}
