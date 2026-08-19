class Solution {
    fun findMaxConsecutiveOnes(nums:IntArray):Int{
        var current=0;
        var best=0;
        for(value in nums){
            current=if(value==1)current+1 else 0;
            best=maxOf(best,current)
        };
        return best
    }
}
