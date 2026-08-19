class Solution {
    fun maxProbability(n:Int,edges:Array<IntArray>,succProb:DoubleArray,start:Int,end:Int):Double{
        val graph=Array(n){
            mutableListOf<Pair<Int,Double>>()
        };
        for(i in edges.indices){
            graph[edges[i][0]].add(edges[i][1] to succProb[i]);
            graph[edges[i][1]].add(edges[i][0] to succProb[i])
        };
        val best=DoubleArray(n);
        best[start]=1.0;
        val heap=java.util.PriorityQueue<Pair<Double,Int>>(compareByDescending{
            it.first
        });
        heap.add(1.0 to start);
        while(heap.isNotEmpty()){
            val(probability,node)=heap.remove();
            if(probability<best[node])continue;
            if(node==end)return probability;
            for((next,edgeProbability)in graph[node]){
                val candidate=probability*edgeProbability;
                if(candidate>best[next]){
                    best[next]=candidate;
                    heap.add(candidate to next)
                }
            }
        };
        return 0.0
    }
}
