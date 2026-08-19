class Solution {
    fun maximumValueSum(nums:IntArray,k:Int,edges:Array<IntArray>):Long{
        var sum=0L
        var even=0L
        var odd=Long.MIN_VALUE/4
        for(value in nums){
            sum+=value
            val gain=(value xor k).toLong()-value
            val nextEven=maxOf(even,odd+gain)
            val nextOdd=maxOf(odd,even+gain)
            even=nextEven
            odd=nextOdd
        }
        return sum+even
    }
}
