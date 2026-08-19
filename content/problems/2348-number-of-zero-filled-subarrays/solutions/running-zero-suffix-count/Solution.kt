class Solution {
    fun zeroFilledSubarray(nums:IntArray):Long{
        var run=0L;
        var answer=0L;
        for(value in nums){
            run=if(value==0)run+1 else 0;
            answer+=run
        };
        return answer
    }
}
