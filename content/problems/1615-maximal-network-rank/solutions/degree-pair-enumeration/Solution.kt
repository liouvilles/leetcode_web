class Solution {
    fun maximalNetworkRank(n:Int,roads:Array<IntArray>):Int{
        val degree=IntArray(n);
        val connected=Array(n){
            BooleanArray(n)
        };
        for(road in roads){
            degree[road[0]]++;
            degree[road[1]]++;
            connected[road[0]][road[1]]=true;
            connected[road[1]][road[0]]=true
        };
        var answer=0;
        for(first in 0 until n)for(second in first+1 until n)answer=maxOf(answer,degree[first]+degree[second]-if(connected[first][second])1 else 0);
        return answer
    }
}
