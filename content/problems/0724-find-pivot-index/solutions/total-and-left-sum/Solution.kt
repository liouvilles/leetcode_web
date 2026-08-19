class Solution {
    fun pivotIndex(nums:IntArray):Int{
        val total=nums.sum();
        var left=0;
        for(index in nums.indices){
            if(left==total-left-nums[index])return index;
            left+=nums[index]
        };
        return -1
    }
}
