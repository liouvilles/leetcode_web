class Solution {
    fun minOperations(k:Int):Int{
        val value=kotlin.math.sqrt(k.toDouble()).toInt();
        val copies=(k+value-1)/value;
        return value+copies-2
    }
}
