class Solution {
    fun minimumPossibleSum(n:Int,target:Int):Int{
        val first=minOf(n,target/2).toLong();
        val remaining=n-first;
        val answer=first*(first+1)/2+remaining*(2L*target+remaining-1)/2;
        return (answer%1000000007).toInt()
    }
}
