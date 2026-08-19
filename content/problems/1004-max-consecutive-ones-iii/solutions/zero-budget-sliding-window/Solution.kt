class Solution {
    fun longestOnes(nums:IntArray,k:Int):Int{
        var left=0;
        var zeros=0;
        var answer=0;
        for(right in nums.indices){
            if(nums[right]==0)zeros++;
            while(zeros>k)if(nums[left++]==0)zeros--;
            answer=maxOf(answer,right-left+1)
        };
        return answer
    }
}
