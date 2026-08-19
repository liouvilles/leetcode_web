class Solution {
    fun magnificentSets(n:Int,edges:Array<IntArray>):Int{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]-1].add(edge[1]-1);
            graph[edge[1]-1].add(edge[0]-1)
        };
        val color=IntArray(n){
            -1
        };
        var answer=0;
        for(root in 0 until n)if(color[root]<0){
            val component=mutableListOf<Int>();
            val queue=java.util.ArrayDeque<Int>();
            queue.offer(root);
            color[root]=0;
            while(queue.isNotEmpty()){
                val node=queue.poll();
                component.add(node);
                for(next in graph[node]){
                    if(color[next]<0){
                        color[next]=color[node] xor 1;
                        queue.offer(next)
                    }else if(color[next]==color[node])return -1
                }
            };
            var best=0;
            for(start in component){
                val distance=IntArray(n){
                    -1
                };
                queue.offer(start);
                distance[start]=0;
                var farthest=0;
                while(queue.isNotEmpty()){
                    val node=queue.poll();
                    for(next in graph[node])if(distance[next]<0){
                        distance[next]=distance[node]+1;
                        farthest=maxOf(farthest,distance[next]);
                        queue.offer(next)
                    }
                };
                best=maxOf(best,farthest+1)
            };
            answer+=best
        };
        return answer
    }
}
