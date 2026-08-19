class Solution {
    fun findMinHeightTrees(n:Int,edges:Array<IntArray>):List<Int>{
        if(n==1)return listOf(0);
        val graph=List(n){
            mutableListOf<Int>()
        };
        val degree=IntArray(n);
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++
        };
        val leaves=ArrayDeque<Int>();
        for(i in 0 until n)if(degree[i]==1)leaves.addLast(i);
        var remaining=n;
        while(remaining>2){
            val size=leaves.size;
            remaining-=size;
            repeat(size){
                val leaf=leaves.removeFirst();
                for(neighbor in graph[leaf])if(--degree[neighbor]==1)leaves.addLast(neighbor)
            }
        };
        return leaves.sorted()
    }
}
