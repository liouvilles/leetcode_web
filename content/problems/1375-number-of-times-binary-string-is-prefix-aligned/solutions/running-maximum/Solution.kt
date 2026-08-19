class Solution {
    fun numTimesAllBlue(flips:IntArray):Int{
        var maximum=0;
        var answer=0;
        for(i in flips.indices){
            maximum=maxOf(maximum,flips[i]);
            if(maximum==i+1)answer++
        };
        return answer
    }
}
