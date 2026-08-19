class Solution {
    private fun dfs(node:Int,parent:Int,time:Int,target:Int,probability:Double,graph:Array<MutableList<Int>>,limit:Int):Double{
        if(time==limit)return if(node==target)probability else 0.0;
        val children=graph[node].count{
            it!=parent
        };
        if(children==0)return if(node==target)probability else 0.0;
        var answer=0.0;
        for(next in graph[node])if(next!=parent)answer+=dfs(next,node,time+1,target,probability/children,graph,limit);
        return answer
    };
    fun frogPosition(n:Int,edges:Array<IntArray>,t:Int,target:Int):Double{
        val graph=Array(n+1){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        return dfs(1,0,0,target,1.0,graph,t)
    }
}
