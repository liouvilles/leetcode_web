class Solution {
    fun minCostConnectPoints(points:Array<IntArray>):Int{
        val n=points.size;
        val distance=IntArray(n){
            Int.MAX_VALUE
        };
        distance[0]=0;
        val used=BooleanArray(n);
        var answer=0;
        repeat(n){
            var node=-1;
            for(i in 0 until n)if(!used[i]&&(node==-1||distance[i]<distance[node]))node=i;
            used[node]=true;
            answer+=distance[node];
            for(next in 0 until n)if(!used[next]){
                val cost=kotlin.math.abs(points[node][0]-points[next][0])+kotlin.math.abs(points[node][1]-points[next][1]);
                distance[next]=minOf(distance[next],cost)
            }
        };
        return answer
    }
}
