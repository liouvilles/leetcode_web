class Solution {
    fun maximumDifference(nums:IntArray):Int{
        var minimum=nums[0];
        var answer=-1;
        for(i in 1 until nums.size){
            if(nums[i]>minimum)answer=maxOf(answer,nums[i]-minimum);
            minimum=minOf(minimum,nums[i])
        };
        return answer
    }
}
