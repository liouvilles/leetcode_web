class Solution {
    fun minScore(n:Int,roads:Array<IntArray>):Int{
        val graph=Array(n){
            mutableListOf<IntArray>()
        };
        for(road in roads){
            graph[road[0]-1].add(intArrayOf(road[1]-1,road[2]));
            graph[road[1]-1].add(intArrayOf(road[0]-1,road[2]))
        };
        val visited=BooleanArray(n);
        val queue=java.util.ArrayDeque<Int>();
        queue.offer(0);
        visited[0]=true;
        var answer=Int.MAX_VALUE;
        while(queue.isNotEmpty()){
            val node=queue.poll();
            for(edge in graph[node]){
                answer=minOf(answer,edge[1]);
                if(!visited[edge[0]]){
                    visited[edge[0]]=true;
                    queue.offer(edge[0])
                }
            }
        };
        return answer
    }
}
