class Solution {
    fun waysToSplitArray(nums:IntArray):Int{
        val total=nums.sumOf{
            it.toLong()
        };
        var prefix=0L;
        var answer=0;
        for(i in 0 until nums.lastIndex){
            prefix+=nums[i];
            if(prefix>=total-prefix)answer++
        };
        return answer
    }
}
