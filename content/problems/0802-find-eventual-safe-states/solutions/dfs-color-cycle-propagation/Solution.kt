class Solution {
    fun eventualSafeNodes(graph:Array<IntArray>):List<Int>{
        val color=IntArray(graph.size);
        val answer=mutableListOf<Int>();
        for(node in graph.indices)if(safe(node,graph,color))answer.add(node);
        return answer
    };
    private fun safe(node:Int,graph:Array<IntArray>,color:IntArray):Boolean{
        if(color[node]!=0)return color[node]==2;
        color[node]=1;
        for(next in graph[node])if(!safe(next,graph,color)){
            color[node]=3;
            return false
        };
        color[node]=2;
        return true
    }
}
