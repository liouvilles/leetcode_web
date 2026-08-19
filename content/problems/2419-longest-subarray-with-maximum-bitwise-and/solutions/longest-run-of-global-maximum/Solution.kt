class Solution {
    fun longestSubarray(nums:IntArray):Int{
        val maximum=nums.maxOrNull()!!;
        var current=0;
        var answer=0;
        for(value in nums){
            current=if(value==maximum)current+1 else 0;
            answer=maxOf(answer,current)
        };
        return answer
    }
}
