class Solution {
    fun minimumAverageDifference(nums:IntArray):Int{
        val total=nums.sumOf{
            it.toLong()
        };
        var prefix=0L;
        var best=Long.MAX_VALUE;
        var answer=0;
        for(i in nums.indices){
            prefix+=nums[i];
            val left=prefix/(i+1);
            val right=if(i==nums.lastIndex)0 else (total-prefix)/(nums.size-i-1);
            val difference=kotlin.math.abs(left-right);
            if(difference<best){
                best=difference;
                answer=i
            }
        };
        return answer
    }
}
