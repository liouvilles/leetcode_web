class Solution {
    fun deleteAndEarn(nums:IntArray):Int{
        val points=IntArray((nums.maxOrNull()?:0)+1);
        for(value in nums)points[value]+=value;
        var take=0;
        var skip=0;
        for(score in points){
            val newTake=skip+score;
            val newSkip=maxOf(skip,take);
            take=newTake;
            skip=newSkip
        };
        return maxOf(take,skip)
    }
}
