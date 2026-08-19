class Solution {
    fun maximizeWin(prizePositions:IntArray,k:Int):Int{
        val best=IntArray(prizePositions.size+1);
        var left=0;
        var answer=0;
        for(right in prizePositions.indices){
            while(prizePositions[right]-prizePositions[left]>k)left++;
            val current=right-left+1;
            answer=maxOf(answer,current+best[left]);
            best[right+1]=maxOf(best[right],current)
        };
        return answer
    }
}
