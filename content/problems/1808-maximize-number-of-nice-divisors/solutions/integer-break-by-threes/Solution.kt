class Solution {
    companion object{
        const val MOD=1_000_000_007L
    };
    private fun power(baseValue:Long,exponentValue:Int):Long{
        var base=baseValue;
        var exponent=exponentValue;
        var answer=1L;
        while(exponent>0){
            if(exponent and 1==1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent=exponent shr 1
        };
        return answer
    };
    fun maxNiceDivisors(primeFactors:Int):Int{
        if(primeFactors<=3)return primeFactors;
        val quotient=primeFactors/3;
        return when(primeFactors%3){
            0->power(3,quotient);
            1->power(3,quotient-1)*4%MOD;
            else->power(3,quotient)*2%MOD
        }.toInt()
    }
}
