class Solution {
    fun sumOfSquares(nums:IntArray):Int{
        var answer=0;
        for(i in nums.indices)if(nums.size%(i+1)==0)answer+=nums[i]*nums[i];
        return answer
    }
}
