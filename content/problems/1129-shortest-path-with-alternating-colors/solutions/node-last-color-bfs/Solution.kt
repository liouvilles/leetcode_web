class Solution {
    fun shortestAlternatingPaths(n:Int,redEdges:Array<IntArray>,blueEdges:Array<IntArray>):IntArray{
        val graph=Array(2){
            Array(n){
                mutableListOf<Int>()
            }
        };
        for(edge in redEdges)graph[0][edge[0]].add(edge[1]);
        for(edge in blueEdges)graph[1][edge[0]].add(edge[1]);
        val distance=Array(n){
            intArrayOf(-1,-1)
        };
        val queue=java.util.ArrayDeque<IntArray>();
        for(color in 0..1){
            distance[0][color]=0;
            queue.addLast(intArrayOf(0,color))
        };
        while(queue.isNotEmpty()){
            val state=queue.removeFirst();
            val nextColor=1-state[1];
            for(next in graph[nextColor][state[0]])if(distance[next][nextColor]<0){
                distance[next][nextColor]=distance[state[0]][state[1]]+1;
                queue.addLast(intArrayOf(next,nextColor))
            }
        };
        return IntArray(n){
            i->when{
                distance[i][0]<0->distance[i][1];
                distance[i][1]<0->distance[i][0];
                else->minOf(distance[i][0],distance[i][1])
            }
        }
    }
}
