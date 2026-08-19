class Solution {
    fun maximumSubarraySum(nums:IntArray,k:Int):Long{
        val minimumPrefix=HashMap<Int,Long>();
        var prefix=0L;
        var answer=Long.MIN_VALUE;
        for(value in nums){
            val endPrefix=prefix+value;
            minimumPrefix[value-k]?.let{
                answer=maxOf(answer,endPrefix-it)
            };
            minimumPrefix[value+k]?.let{
                answer=maxOf(answer,endPrefix-it)
            };
            minimumPrefix[value]=minOf(minimumPrefix[value]?:Long.MAX_VALUE,prefix);
            prefix=endPrefix
        };
        return if(answer==Long.MIN_VALUE)0 else answer
    }
}
