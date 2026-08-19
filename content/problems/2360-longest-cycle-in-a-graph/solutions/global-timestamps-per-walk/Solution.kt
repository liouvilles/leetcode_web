class Solution {
    fun longestCycle(edges:IntArray):Int{
        val visitedTime=IntArray(edges.size);
        var time=1;
        var answer=-1;
        for(start in edges.indices)if(visitedTime[start]==0){
            val startTime=time;
            var node=start;
            while(node!=-1&&visitedTime[node]==0){
                visitedTime[node]=time++;
                node=edges[node]
            };
            if(node!=-1&&visitedTime[node]>=startTime)answer=maxOf(answer,time-visitedTime[node])
        };
        return answer
    }
}
