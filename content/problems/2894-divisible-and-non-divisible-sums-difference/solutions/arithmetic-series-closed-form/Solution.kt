class Solution {
    fun differenceOfSums(n:Int,m:Int):Int{
        val count=n/m;
        val total=n*(n+1)/2;
        val divisible=m*count*(count+1)/2;
        return total-2*divisible
    }
}
