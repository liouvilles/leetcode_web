class Solution {
    private fun dfs(node:Int,parent:Int,graph:Array<MutableList<IntArray>>):Int{
        var answer=0;
        for(edge in graph[node])if(edge[0]!=parent)answer+=edge[1]+dfs(edge[0],node,graph);
        return answer
    };
    fun minReorder(n:Int,connections:Array<IntArray>):Int{
        val graph=Array(n){
            mutableListOf<IntArray>()
        };
        for(edge in connections){
            graph[edge[0]].add(intArrayOf(edge[1],1));
            graph[edge[1]].add(intArrayOf(edge[0],0))
        };
        return dfs(0,-1,graph)
    }
}
