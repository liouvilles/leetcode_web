class Solution {
    private fun cost(nums:IntArray,prefix:LongArray,left:Int,right:Int):Long{
        val middle=(left+right) ushr 1;
        val leftCost=nums[middle].toLong()*(middle-left)-(prefix[middle]-prefix[left]);
        val rightCost=prefix[right+1]-prefix[middle+1]-nums[middle].toLong()*(right-middle);
        return leftCost+rightCost
    };
    fun maxFrequencyScore(nums:IntArray,k:Long):Int{
        nums.sort();
        val prefix=LongArray(nums.size+1);
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i].toLong();
        var left=0;
        var answer=1;
        for(right in nums.indices){
            while(cost(nums,prefix,left,right)>k)left++;
            answer=maxOf(answer,right-left+1)
        };
        return answer
    }
}
