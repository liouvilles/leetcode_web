class Solution {
    fun numWays(steps:Int,arrLen:Int):Int{
        val limit=minOf(arrLen,steps/2+1);
        val mod=1000000007L;
        var dp=LongArray(limit);
        dp[0]=1;
        repeat(steps){
            val next=LongArray(limit);
            for(position in 0 until limit){
                next[position]=(next[position]+dp[position])%mod;
                if(position>0)next[position-1]=(next[position-1]+dp[position])%mod;
                if(position+1<limit)next[position+1]=(next[position+1]+dp[position])%mod
            };
            dp=next
        };
        return dp[0].toInt()
    }
}
