class Solution {
    fun largestCombination(candidates:IntArray):Int{
        var answer=0;
        for(bit in 0 until 31)answer=maxOf(answer,candidates.count{
            it and (1 shl bit)!=0
        });
        return answer
    }
}
