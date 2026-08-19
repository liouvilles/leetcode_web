class Solution {
    fun longestWPI(hours:IntArray):Int{
        val earliest=mutableMapOf<Int,Int>();
        var score=0;
        var answer=0;
        for(i in hours.indices){
            score+=if(hours[i]>8)1 else -1;
            if(score>0)answer=i+1 else if(score-1 in earliest)answer=maxOf(answer,i-earliest[score-1]!!);
            earliest.putIfAbsent(score,i)
        };
        return answer
    }
}
