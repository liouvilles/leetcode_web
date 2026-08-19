class Solution {
    companion object{
        const val MOD=1_000_000_007L
    };
    private fun power(baseValue:Long,exponentValue:Long):Long{
        var base=baseValue;
        var exponent=exponentValue;
        var result=1L;
        while(exponent>0){
            if(exponent and 1L==1L)result=result*base%MOD;
            base=base*base%MOD;
            exponent=exponent shr 1
        };
        return result
    };
    fun countGoodNumbers(n:Long)=(power(5,(n+1)/2)*power(4,n/2)%MOD).toInt()
}
