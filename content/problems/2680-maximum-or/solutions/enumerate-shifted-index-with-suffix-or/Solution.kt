class Solution {
    fun maximumOr(nums:IntArray,k:Int):Long{
        val suffix=LongArray(nums.size+1);
        for(i in nums.lastIndex downTo 0)suffix[i]=suffix[i+1] or nums[i].toLong();
        var prefix=0L;
        var answer=0L;
        for(i in nums.indices){
            answer=maxOf(answer,prefix or (nums[i].toLong() shl k) or suffix[i+1]);
            prefix=prefix or nums[i].toLong()
        };
        return answer
    }
}
