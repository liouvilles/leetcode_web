class Solution {
    fun findUnsortedSubarray(nums:IntArray):Int{
        var maximum=nums[0];
        var right=-1;
        for(i in 1 until nums.size)if(nums[i]<maximum)right=i else maximum=nums[i];
        if(right==-1)return 0;
        var minimum=nums.last();
        var left=0;
        for(i in nums.lastIndex-1 downTo 0)if(nums[i]>minimum)left=i else minimum=nums[i];
        return right-left+1
    }
}
