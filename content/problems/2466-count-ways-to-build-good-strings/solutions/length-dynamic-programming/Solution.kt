class Solution {
    fun countGoodStrings(low:Int,high:Int,zero:Int,one:Int):Int{
        val mod=1_000_000_007L;
        val dp=LongArray(high+1);
        dp[0]=1;
        for(length in 0..high){
            if(length+zero<=high)dp[length+zero]=(dp[length+zero]+dp[length])%mod;
            if(length+one<=high)dp[length+one]=(dp[length+one]+dp[length])%mod
        };
        var answer=0L;
        for(length in low..high)answer=(answer+dp[length])%mod;
        return answer.toInt()
    }
}
