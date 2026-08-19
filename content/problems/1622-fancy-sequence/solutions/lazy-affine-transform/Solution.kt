class Fancy {
    companion object{
        const val MOD=1_000_000_007L
    };
    private val values=mutableListOf<Long>();
    private var multiply=1L;
    private var add=0L;
    private fun power(baseValue:Long,exponentValue:Long):Long{
        var base=baseValue;
        var exponent=exponentValue;
        var answer=1L;
        while(exponent>0){
            if(exponent and 1L==1L)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent=exponent shr 1
        };
        return answer
    };
    fun append(value:Int){
        val normalized=(value-add+MOD)%MOD;
        values.add(normalized*power(multiply,MOD-2)%MOD)
    };
    fun addAll(inc:Int){
        add=(add+inc)%MOD
    };
    fun multAll(m:Int){
        multiply=multiply*m%MOD;
        add=add*m%MOD
    };
    fun getIndex(index:Int):Int=if(index>=values.size)-1 else ((values[index]*multiply+add)%MOD).toInt()
}
