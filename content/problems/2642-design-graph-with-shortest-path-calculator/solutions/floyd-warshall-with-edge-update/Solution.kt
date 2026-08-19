class Graph(n:Int,edges:Array<IntArray>){
    private val inf=1L shl 50;
    private val distance=Array(n){
        LongArray(n){
            inf
        }
    };
    init{
        for(i in 0 until n)distance[i][i]=0;
        for(edge in edges)distance[edge[0]][edge[1]]=minOf(distance[edge[0]][edge[1]],edge[2].toLong());
        for(middle in 0 until n)for(from in 0 until n)for(to in 0 until n)distance[from][to]=minOf(distance[from][to],distance[from][middle]+distance[middle][to])
    }
    fun addEdge(edge:IntArray){
        val from=edge[0];
        val to=edge[1];
        val weight=edge[2];
        if(weight>=distance[from][to])return;
        for(start in distance.indices)if(distance[start][from]<inf)for(end in distance.indices)if(distance[to][end]<inf)distance[start][end]=minOf(distance[start][end],distance[start][from]+weight+distance[to][end])
    }
    fun shortestPath(node1:Int,node2:Int):Int=if(distance[node1][node2]>=inf)-1 else distance[node1][node2].toInt()
}
