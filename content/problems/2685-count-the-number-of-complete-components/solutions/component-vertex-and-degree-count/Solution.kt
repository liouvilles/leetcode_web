class Solution {
    fun countCompleteComponents(n:Int,edges:Array<IntArray>):Int{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val visited=BooleanArray(n);
        var answer=0;
        for(start in 0 until n)if(!visited[start]){
            val queue=java.util.ArrayDeque<Int>();
            queue.add(start);
            visited[start]=true;
            var vertices=0;
            var degreeSum=0;
            while(queue.isNotEmpty()){
                val node=queue.removeFirst();
                vertices++;
                degreeSum+=graph[node].size;
                for(next in graph[node])if(!visited[next]){
                    visited[next]=true;
                    queue.add(next)
                }
            };
            if(degreeSum==vertices*(vertices-1))answer++
        };
        return answer
    }
}
