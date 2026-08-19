class Solution {
    fun minCost(colors:String,neededTime:IntArray):Int{
        var answer=0;
        var kept=neededTime[0];
        for(i in 1 until colors.length)if(colors[i]==colors[i-1]){
            answer+=minOf(kept,neededTime[i]);
            kept=maxOf(kept,neededTime[i])
        }else kept=neededTime[i];
        return answer
    }
}
