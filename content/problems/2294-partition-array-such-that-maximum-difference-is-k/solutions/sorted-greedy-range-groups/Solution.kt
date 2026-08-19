class Solution {
    fun partitionArray(nums:IntArray,k:Int):Int{
        nums.sort();
        var groups=1;
        var start=nums[0];
        for(value in nums)if(value-start>k){
            groups++;
            start=value
        };
        return groups
    }
}
