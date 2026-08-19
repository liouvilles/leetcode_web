class Solution {
    fun stringCount(n:Int):Int{
        val mod=1000000007L;
        var dp=Array(2){
            Array(3){
                LongArray(2)
            }
        };
        dp[0][0][0]=1;
        repeat(n){
            val next=Array(2){
                Array(3){
                    LongArray(2)
                }
            };
            for(l in 0..1)for(e in 0..2)for(t in 0..1){
                val ways=dp[l][e][t];
                next[l][e][t]=(next[l][e][t]+23*ways)%mod;
                next[1][e][t]=(next[1][e][t]+ways)%mod;
                next[l][minOf(2,e+1)][t]=(next[l][minOf(2,e+1)][t]+ways)%mod;
                next[l][e][1]=(next[l][e][1]+ways)%mod
            };
            dp=next
        };
        return dp[1][2][1].toInt()
    }
}
