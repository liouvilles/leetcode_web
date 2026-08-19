class Solution {
    fun findLengthOfLCIS(nums:IntArray):Int{
        var current=1;
        var best=1;
        for(i in 1 until nums.size){
            current=if(nums[i]>nums[i-1])current+1 else 1;
            best=maxOf(best,current)
        };
        return best
    }
}
