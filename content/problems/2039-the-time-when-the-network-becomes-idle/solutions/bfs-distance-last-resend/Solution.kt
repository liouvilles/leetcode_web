class Solution {
    fun networkBecomesIdle(edges:Array<IntArray>,patience:IntArray):Int{
        val n=patience.size;
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val distance=IntArray(n){
            -1
        };
        val queue=java.util.ArrayDeque<Int>();
        queue.add(0);
        distance[0]=0;
        while(queue.isNotEmpty()){
            val node=queue.removeFirst();
            for(next in graph[node])if(distance[next]<0){
                distance[next]=distance[node]+1;
                queue.add(next)
            }
        };
        var answer=0;
        for(node in 1 until n){
            val roundTrip=2*distance[node];
            val lastSend=(roundTrip-1)/patience[node]*patience[node];
            answer=maxOf(answer,lastSend+roundTrip+1)
        };
        return answer
    }
}
