class Solution {
    fun findTheCity(n:Int,edges:Array<IntArray>,distanceThreshold:Int):Int{
        val infinity=1000000000;
        val distance=Array(n){
            IntArray(n){
                infinity
            }
        };
        for(i in 0 until n)distance[i][i]=0;
        for(edge in edges){
            distance[edge[0]][edge[1]]=minOf(distance[edge[0]][edge[1]],edge[2]);
            distance[edge[1]][edge[0]]=distance[edge[0]][edge[1]]
        };
        for(k in 0 until n)for(i in 0 until n)for(j in 0 until n)distance[i][j]=minOf(distance[i][j],distance[i][k]+distance[k][j]);
        var answer=-1;
        var bestCount=Int.MAX_VALUE;
        for(city in 0 until n){
            var count=0;
            for(other in 0 until n)if(other!=city&&distance[city][other]<=distanceThreshold)count++;
            if(count<=bestCount){
                bestCount=count;
                answer=city
            }
        };
        return answer
    }
}
