class Solution {
    private fun dijkstra(source:Int,graph:Array<MutableList<IntArray>>):LongArray{
        val infinity=Long.MAX_VALUE/4;
        val distance=LongArray(graph.size){
            infinity
        };
        distance[source]=0;
        val queue=java.util.PriorityQueue<LongArray>(compareBy<LongArray>{
            it[0]
        });
        queue.add(longArrayOf(0,source.toLong()));
        while(queue.isNotEmpty()){
            val current=queue.poll();
            val cost=current[0];
            val node=current[1].toInt();
            if(cost!=distance[node])continue;
            for(edge in graph[node]){
                val next=edge[0];
                val candidate=cost+edge[1];
                if(candidate<distance[next]){
                    distance[next]=candidate;
                    queue.add(longArrayOf(candidate,next.toLong()))
                }
            }
        };
        return distance
    }
    fun findAnswer(n:Int,edges:Array<IntArray>):BooleanArray{
        val graph=Array(n){
            mutableListOf<IntArray>()
        };
        for(edge in edges){
            graph[edge[0]].add(intArrayOf(edge[1],edge[2]));
            graph[edge[1]].add(intArrayOf(edge[0],edge[2]))
        };
        val fromStart=dijkstra(0,graph);
        val fromEnd=dijkstra(n-1,graph);
        val shortest=fromStart[n-1];
        return BooleanArray(edges.size){
            index->val u=edges[index][0];
            val v=edges[index][1];
            val weight=edges[index][2];
            fromStart[u]+weight+fromEnd[v]==shortest||fromStart[v]+weight+fromEnd[u]==shortest
        }
    }
}
