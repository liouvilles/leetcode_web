class Solution {
    fun partitionDisjoint(nums:IntArray):Int{
        var leftMax=nums[0];
        var overallMax=nums[0];
        var boundary=0;
        for(i in 1 until nums.size){
            overallMax=maxOf(overallMax,nums[i]);
            if(nums[i]<leftMax){
                boundary=i;
                leftMax=overallMax
            }
        };
        return boundary+1
    }
}
