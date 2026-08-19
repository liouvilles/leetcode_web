class Solution {
    fun findPrefixScore(nums:IntArray):LongArray{
        val answer=LongArray(nums.size);
        var maximum=0;
        var score=0L;
        for(i in nums.indices){
            maximum=maxOf(maximum,nums[i]);
            score+=nums[i]+maximum;
            answer[i]=score
        };
        return answer
    }
}
