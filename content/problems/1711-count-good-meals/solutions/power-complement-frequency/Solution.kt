class Solution {
    fun countPairs(deliciousness:IntArray):Int{
        val mod=1_000_000_007L;
        val frequency=mutableMapOf<Int,Int>();
        var answer=0L;
        for(value in deliciousness){
            var power=1;
            while(power<=1 shl 21){
                answer+=frequency[power-value]?:0;
                power=power shl 1
            };
            answer%=mod;
            frequency[value]=(frequency[value]?:0)+1
        };
        return answer.toInt()
    }
}
