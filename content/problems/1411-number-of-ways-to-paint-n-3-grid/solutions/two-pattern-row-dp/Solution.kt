class Solution {
    fun numOfWays(n:Int):Int{
        val mod=1_000_000_007L;
        var same=6L;
        var different=6L;
        for(row in 2..n){
            val nextSame=(3*same+2*different)%mod;
            val nextDifferent=(2*same+2*different)%mod;
            same=nextSame;
            different=nextDifferent
        };
        return ((same+different)%mod).toInt()
    }
}
