class Solution {
    fun reachableNodes(n:Int,edges:Array<IntArray>,restricted:IntArray):Int{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val blocked=BooleanArray(n);
        for(node in restricted)blocked[node]=true;
        val seen=BooleanArray(n);
        val queue=java.util.ArrayDeque<Int>();
        queue.add(0);
        seen[0]=true;
        var answer=0;
        while(queue.isNotEmpty()){
            val node=queue.removeFirst();
            answer++;
            for(next in graph[node])if(!seen[next]&&!blocked[next]){
                seen[next]=true;
                queue.add(next)
            }
        };
        return answer
    }
}
