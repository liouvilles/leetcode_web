class Solution {
    fun findClosestNumber(nums:IntArray):Int{
        var answer=nums[0];
        for(value in nums)if(kotlin.math.abs(value)<kotlin.math.abs(answer)||kotlin.math.abs(value)==kotlin.math.abs(answer)&&value>answer)answer=value;
        return answer
    }
}
