class Solution {
    fun maxSumTwoNoOverlap(nums:IntArray,firstLen:Int,secondLen:Int):Int{
        val prefix=IntArray(nums.size+1);
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i];
        fun order(leftLength:Int,rightLength:Int):Int{
            var bestLeft=0;
            var answer=0;
            for(start in leftLength..nums.size-rightLength){
                bestLeft=maxOf(bestLeft,prefix[start]-prefix[start-leftLength]);
                answer=maxOf(answer,bestLeft+prefix[start+rightLength]-prefix[start])
            };
            return answer
        };
        return maxOf(order(firstLen,secondLen),order(secondLen,firstLen))
    }
}
