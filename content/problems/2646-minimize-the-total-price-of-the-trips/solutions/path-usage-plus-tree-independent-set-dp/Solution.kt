class Solution {
    fun minimumTotalPrice(n:Int,edges:Array<IntArray>,price:IntArray,trips:Array<IntArray>):Int{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val usage=IntArray(n);
        fun addPath(node:Int,parent:Int,target:Int):Boolean{
            if(node==target){
                usage[node]++;
                return true
            };
            for(next in graph[node])if(next!=parent&&addPath(next,node,target)){
                usage[node]++;
                return true
            };
            return false
        };
        for(trip in trips)addPath(trip[0],-1,trip[1]);
        fun solve(node:Int,parent:Int):LongArray{
            val full=usage[node].toLong()*price[node];
            var notHalf=full;
            var half=full/2;
            for(next in graph[node])if(next!=parent){
                val child=solve(next,node);
                notHalf+=minOf(child[0],child[1]);
                half+=child[0]
            };
            return longArrayOf(notHalf,half)
        };
        val answer=solve(0,-1);
        return minOf(answer[0],answer[1]).toInt()
    }
}
