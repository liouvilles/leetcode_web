class Solution {
    fun longestAlternatingSubarray(nums:IntArray,threshold:Int):Int{
        var current=0;
        var answer=0;
        for(i in nums.indices){
            current=if(nums[i]>threshold)0 else if(current==0)if(nums[i]%2==0)1 else 0 else if(nums[i]%2!=nums[i-1]%2)current+1 else if(nums[i]%2==0)1 else 0;
            answer=maxOf(answer,current)
        };
        return answer
    }
}
