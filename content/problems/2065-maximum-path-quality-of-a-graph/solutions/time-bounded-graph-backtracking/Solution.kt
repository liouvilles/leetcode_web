class Solution {
    private lateinit var graph:Array<MutableList<IntArray>>;
    private lateinit var values:IntArray;
    private lateinit var visits:IntArray;
    private var maximumTime=0;
    private var answer=0;
    private fun dfs(node:Int,used:Int,quality:Int){
        if(node==0)answer=maxOf(answer,quality);
        for(edge in graph[node])if(used+edge[1]<=maximumTime){
            val next=edge[0];
            val gain=if(visits[next]++==0)values[next] else 0;
            dfs(next,used+edge[1],quality+gain);
            visits[next]--
        }
    };
    fun maximalPathQuality(values:IntArray,edges:Array<IntArray>,maxTime:Int):Int{
        this.values=values;
        maximumTime=maxTime;
        graph=Array(values.size){
            mutableListOf()
        };
        for(edge in edges){
            graph[edge[0]].add(intArrayOf(edge[1],edge[2]));
            graph[edge[1]].add(intArrayOf(edge[0],edge[2]))
        };
        visits=IntArray(values.size);
        visits[0]=1;
        dfs(0,0,values[0]);
        return answer
    }
}
