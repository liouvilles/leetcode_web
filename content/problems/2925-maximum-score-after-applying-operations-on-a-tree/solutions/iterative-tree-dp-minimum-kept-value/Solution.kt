class Solution {
    fun maximumScoreAfterOperations(edges:Array<IntArray>,values:IntArray):Long{
        val n=values.size;
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val parent=IntArray(n){
            -1
        };
        val order=IntArray(n);
        parent[0]=0;
        var size=0;
        val stack=java.util.ArrayDeque<Int>();
        stack.push(0);
        while(stack.isNotEmpty()){
            val node=stack.pop();
            order[size++]=node;
            for(next in graph[node])if(parent[next]==-1){
                parent[next]=node;
                stack.push(next)
            }
        };
        var total=0L;
        for(value in values)total+=value;
        val keep=LongArray(n);
        for(index in n-1 downTo 0){
            val node=order[index];
            var children=0L;
            var leaf=true;
            for(next in graph[node])if(parent[next]==node){
                leaf=false;
                children+=keep[next]
            };
            keep[node]=if(leaf)values[node].toLong() else minOf(values[node].toLong(),children)
        };
        return total-keep[0]
    }
}
