class Solution {
    fun minimumCost(cost:IntArray):Int{
        cost.sortDescending();
        var answer=0;
        for(i in cost.indices)if(i%3!=2)answer+=cost[i];
        return answer
    }
}
