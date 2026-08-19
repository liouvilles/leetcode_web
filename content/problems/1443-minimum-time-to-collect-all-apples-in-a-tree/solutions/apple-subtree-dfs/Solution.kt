class Solution {
    private fun dfs(node:Int,parent:Int,graph:Array<MutableList<Int>>,hasApple:List<Boolean>):Int{
        var cost=0;
        for(child in graph[node])if(child!=parent){
            val childCost=dfs(child,node,graph,hasApple);
            if(childCost>0||hasApple[child])cost+=childCost+2
        };
        return cost
    };
    fun minTime(n:Int,edges:Array<IntArray>,hasApple:List<Boolean>):Int{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        return dfs(0,-1,graph,hasApple)
    }
}
