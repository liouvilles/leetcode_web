class Solution {
    fun maxKDivisibleComponents(n:Int,edges:Array<IntArray>,values:IntArray,k:Int):Int{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val parent=IntArray(n){
            -2
        };
        val order=IntArray(n);
        parent[0]=-1;
        order[0]=0;
        var length=1;
        var index=0;
        while(index<length){
            val node=order[index++];
            for(next in graph[node])if(next!=parent[node]){
                parent[next]=node;
                order[length++]=next
            }
        };
        val divisor=k.toLong();
        val remainder=LongArray(n){
            values[it].toLong()%divisor
        };
        var components=0;
        for(position in n-1 downTo 0){
            val node=order[position];
            if(remainder[node]==0L)components++ else if(parent[node]>=0)remainder[parent[node]]=(remainder[parent[node]]+remainder[node])%divisor
        };
        return components
    }
}
