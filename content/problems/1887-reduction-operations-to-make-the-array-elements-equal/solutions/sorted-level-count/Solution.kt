class Solution {
    fun reductionOperations(nums:IntArray):Int{
        nums.sort();
        var answer=0;
        for(i in 1 until nums.size)if(nums[i]!=nums[i-1])answer+=i;
        return answer
    }
}
