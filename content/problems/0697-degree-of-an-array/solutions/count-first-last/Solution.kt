class Solution {
    fun findShortestSubArray(nums:IntArray):Int{
        val first=hashMapOf<Int,Int>();
        val count=hashMapOf<Int,Int>();
        var degree=0;
        var length=0;
        for(i in nums.indices){
            val value=nums[i];
            first.putIfAbsent(value,i);
            val frequency=(count[value]?:0)+1;
            count[value]=frequency;
            val span=i-first[value]!!+1;
            if(frequency>degree){
                degree=frequency;
                length=span
            }else if(frequency==degree)length=minOf(length,span)
        };
        return length
    }
}
