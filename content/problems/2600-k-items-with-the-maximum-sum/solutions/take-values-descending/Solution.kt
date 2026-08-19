class Solution {
    fun kItemsWithMaximumSum(numOnes:Int,numZeros:Int,numNegOnes:Int,kInput:Int):Int{
        var k=kInput;
        val ones=minOf(k,numOnes);
        k-=ones;
        k-=minOf(k,numZeros);
        return ones-k
    }
}
