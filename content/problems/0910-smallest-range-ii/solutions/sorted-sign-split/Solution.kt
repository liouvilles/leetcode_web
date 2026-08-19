class Solution {
    fun smallestRangeII(nums:IntArray,k:Int):Int{
        nums.sort();
        var answer=nums.last()-nums.first();
        for(i in 0 until nums.lastIndex){
            val high=maxOf(nums.last()-k,nums[i]+k);
            val low=minOf(nums.first()+k,nums[i+1]-k);
            answer=minOf(answer,high-low)
        };
        return answer
    }
}
