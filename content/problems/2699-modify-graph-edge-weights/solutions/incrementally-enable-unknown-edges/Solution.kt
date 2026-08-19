class Solution {
    private val large=2_000_000_000;
    private fun shortest(n:Int,edges:Array<IntArray>,source:Int,destination:Int):Long{
        val graph=Array(n){
            mutableListOf<IntArray>()
        };
        for(edge in edges)if(edge[2]>=0){
            graph[edge[0]].add(intArrayOf(edge[1],edge[2]));
            graph[edge[1]].add(intArrayOf(edge[0],edge[2]))
        };
        val distance=LongArray(n){
            Long.MAX_VALUE
        };
        distance[source]=0;
        val queue=java.util.PriorityQueue<LongArray>(compareBy<LongArray>{
            it[0]
        });
        queue.add(longArrayOf(0,source.toLong()));
        while(queue.isNotEmpty()){
            val state=queue.poll();
            val cost=state[0];
            val node=state[1].toInt();
            if(cost!=distance[node])continue;
            if(node==destination)return cost;
            for(next in graph[node]){
                val candidate=cost+next[1];
                if(candidate<distance[next[0]]){
                    distance[next[0]]=candidate;
                    queue.add(longArrayOf(candidate,next[0].toLong()))
                }
            }
        };
        return Long.MAX_VALUE
    }
    fun modifiedGraphEdges(n:Int,edges:Array<IntArray>,source:Int,destination:Int,target:Int):Array<IntArray>{
        val fixed=shortest(n,edges,source,destination);
        if(fixed<target)return emptyArray();
        var matched=fixed==target.toLong();
        for(edge in edges)if(edge[2]==-1){
            if(matched)edge[2]=large else{
                edge[2]=1;
                val distance=shortest(n,edges,source,destination);
                if(distance<=target){
                    edge[2]+=(target-distance).toInt();
                    matched=true
                }
            }
        };
        return if(matched)edges else emptyArray()
    }
}
