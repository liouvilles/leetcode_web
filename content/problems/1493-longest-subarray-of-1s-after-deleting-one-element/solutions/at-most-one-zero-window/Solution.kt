class Solution {
    fun longestSubarray(nums:IntArray):Int{
        var left=0;
        var zeros=0;
        var answer=0;
        for(right in nums.indices){
            if(nums[right]==0)zeros++;
            while(zeros>1)if(nums[left++]==0)zeros--;
            answer=maxOf(answer,right-left)
        };
        return answer
    }
}
