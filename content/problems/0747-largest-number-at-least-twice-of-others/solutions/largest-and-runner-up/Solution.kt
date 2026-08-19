class Solution {
    fun dominantIndex(nums:IntArray):Int{
        var maximum=-1;
        var second=-1;
        var index=-1;
        for(i in nums.indices)if(nums[i]>maximum){
            second=maximum;
            maximum=nums[i];
            index=i
        }else second=maxOf(second,nums[i]);
        return if(maximum.toLong()>=2L*second)index else -1
    }
}
