class Solution {
    fun countOrders(n:Int):Int{
        val mod=1_000_000_007L;
        var answer=1L;
        for(i in 1L..n.toLong())answer=answer*i%mod*(2*i-1)%mod;
        return answer.toInt()
    }
}
