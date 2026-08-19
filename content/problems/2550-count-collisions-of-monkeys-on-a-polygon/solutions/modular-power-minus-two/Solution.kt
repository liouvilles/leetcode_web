class Solution {
    fun monkeyMove(nInput:Int):Int{
        val mod=1_000_000_007L;
        var n=nInput;
        var base=2L;
        var result=1L;
        while(n>0){
            if(n and 1==1)result=result*base%mod;
            base=base*base%mod;
            n=n shr 1
        };
        return ((result-2+mod)%mod).toInt()
    }
}
