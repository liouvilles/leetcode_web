class Solution {
    fun triangularSum(nums:IntArray):Int{
        for(length in nums.size downTo 2)for(i in 0 until length-1)nums[i]=(nums[i]+nums[i+1])%10;
        return nums[0]
    }
}
