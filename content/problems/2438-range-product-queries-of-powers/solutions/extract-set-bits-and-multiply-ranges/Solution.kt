class Solution {
    fun productQueries(n:Int,queries:Array<IntArray>):IntArray{
        val powers=mutableListOf<Long>();
        for(bit in 0 until 31)if(n and (1 shl bit)!=0)powers.add(1L shl bit);
        val mod=1_000_000_007L;
        return IntArray(queries.size){
            q->var product=1L;
            for(i in queries[q][0]..queries[q][1])product=product*powers[i]%mod;
            product.toInt()
        }
    }
}
