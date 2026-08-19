class Solution {
    private fun pair(value:Int):IntArray{
        for(divisor in kotlin.math.sqrt(value.toDouble()).toInt() downTo 1)if(value%divisor==0)return intArrayOf(divisor,value/divisor);
        error("unreachable")
    };
    fun closestDivisors(num:Int):IntArray{
        val first=pair(num+1);
        val second=pair(num+2);
        return if(first[1]-first[0]<=second[1]-second[0])first else second
    }
}
