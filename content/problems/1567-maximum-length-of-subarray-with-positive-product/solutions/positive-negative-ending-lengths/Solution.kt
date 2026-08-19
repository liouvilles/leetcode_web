class Solution {
    fun getMaxLen(nums:IntArray):Int{
        var positive=0;
        var negative=0;
        var answer=0;
        for(value in nums){
            if(value>0){
                positive++;
                if(negative>0)negative++
            }else if(value<0){
                val newPositive=if(negative>0)negative+1 else 0;
                val newNegative=positive+1;
                positive=newPositive;
                negative=newNegative
            }else{
                positive=0;
                negative=0
            };
            answer=maxOf(answer,positive)
        };
        return answer
    }
}
