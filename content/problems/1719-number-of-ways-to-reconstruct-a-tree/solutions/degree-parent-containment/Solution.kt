class Solution {
    fun checkWays(pairs:Array<IntArray>):Int{
        val graph=mutableMapOf<Int,MutableSet<Int>>();
        for(pair in pairs){
            graph.getOrPut(pair[0]){
                mutableSetOf()
            }.add(pair[1]);
            graph.getOrPut(pair[1]){
                mutableSetOf()
            }.add(pair[0])
        };
        val root=graph.keys.firstOrNull{
            graph[it]!!.size==graph.size-1
        }?:return 0;
        var answer=1;
        for(node in graph.keys){
            if(node==root)continue;
            val degree=graph[node]!!.size;
            var parent=-1;
            var parentDegree=Int.MAX_VALUE;
            for(neighbor in graph[node]!!){
                val candidateDegree=graph[neighbor]!!.size;
                if(candidateDegree>=degree&&candidateDegree<parentDegree){
                    parent=neighbor;
                    parentDegree=candidateDegree
                }
            };
            if(parent<0)return 0;
            for(neighbor in graph[node]!!)if(neighbor!=parent&&neighbor !in graph[parent]!!)return 0;
            if(parentDegree==degree)answer=2
        };
        return answer
    }
}
