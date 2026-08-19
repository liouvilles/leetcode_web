class Solution {
    fun numRollsToTarget(n:Int,k:Int,target:Int):Int{
        val mod=1000000007L;
        var dp=LongArray(target+1);
        dp[0]=1;
        repeat(n){
            val next=LongArray(target+1);
            for(sum in 1..target)for(face in 1..minOf(k,sum))next[sum]=(next[sum]+dp[sum-face])%mod;
            dp=next
        };
        return dp[target].toInt()
    }
}
