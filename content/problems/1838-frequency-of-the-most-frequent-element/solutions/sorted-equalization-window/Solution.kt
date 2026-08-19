class Solution {
    fun maxFrequency(nums:IntArray,k:Int):Int{
        nums.sort();
        var left=0;
        var answer=0;
        var sum=0L;
        for(right in nums.indices){
            sum+=nums[right];
            while(nums[right].toLong()*(right-left+1)-sum>k)sum-=nums[left++];
            answer=maxOf(answer,right-left+1)
        };
        return answer
    }
}
