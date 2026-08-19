class Solution {
    fun numberOfStableArrays(zero:Int,one:Int,limit:Int):Int{
        val mod=1000000007L;
        val endZero=Array(zero+1){
            IntArray(one+1)
        };
        val endOne=Array(zero+1){
            IntArray(one+1)
        };
        for(count in 1..minOf(zero,limit))endZero[count][0]=1;
        for(count in 1..minOf(one,limit))endOne[0][count]=1;
        for(usedZero in 1..zero)for(usedOne in 1..one){
            var ways=endZero[usedZero-1][usedOne].toLong()+endOne[usedZero-1][usedOne];
            if(usedZero>limit)ways-=endOne[usedZero-limit-1][usedOne];
            endZero[usedZero][usedOne]=((ways+mod)%mod).toInt();
            ways=endZero[usedZero][usedOne-1].toLong()+endOne[usedZero][usedOne-1];
            if(usedOne>limit)ways-=endZero[usedZero][usedOne-limit-1];
            endOne[usedZero][usedOne]=((ways+mod)%mod).toInt()
        };
        return ((endZero[zero][one].toLong()+endOne[zero][one])%mod).toInt()
    }
}
