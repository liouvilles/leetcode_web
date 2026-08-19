class Solution {
    fun missingNumber(nums:IntArray):Int{
        var answer=nums.size;
        for(i in nums.indices)answer=answer xor i xor nums[i];
        return answer
    }
}
