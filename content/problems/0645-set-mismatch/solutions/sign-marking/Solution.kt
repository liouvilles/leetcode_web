class Solution {
    fun findErrorNums(nums:IntArray):IntArray{
        var duplicate=0;
        var missing=0;
        for(item in nums){
            val value=kotlin.math.abs(item);
            val index=value-1;
            if(nums[index]<0)duplicate=value else nums[index]=-nums[index]
        };
        for(i in nums.indices)if(nums[i]>0)missing=i+1;
        return intArrayOf(duplicate,missing)
    }
}
