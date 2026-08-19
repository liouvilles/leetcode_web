class Solution {
    fun maxOutput(n:Int,edges:Array<IntArray>,price:IntArray):Long{
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
        var size=1;
        var index=0;
        while(index<size){
            val node=order[index++];
            for(next in graph[node])if(parent[next]==-2){
                parent[next]=node;
                order[size++]=next
            }
        };
        val full=LongArray(n);
        val excluded=LongArray(n);
        var answer=0L;
        for(position in n-1 downTo 0){
            val node=order[position];
            var bestFull=price[node].toLong();
            var bestExcluded=0L;
            for(child in graph[node])if(parent[child]==node){
                answer=maxOf(answer,bestFull+excluded[child],bestExcluded+full[child]);
                bestFull=maxOf(bestFull,price[node]+full[child]);
                bestExcluded=maxOf(bestExcluded,price[node]+excluded[child])
            };
            full[node]=bestFull;
            excluded[node]=bestExcluded
        };
        return answer
    }
}
