class Solution {
    companion object{
        const val MOD=1_000_000_007
    };
    private lateinit var graph:Array<MutableList<IntArray>>;
    private lateinit var distance:LongArray;
    private lateinit var memo:IntArray;
    private var target=0;
    private fun dfs(node:Int):Int{
        if(node==target)return 1;
        if(memo[node]>=0)return memo[node];
        var ways=0L;
        for(edge in graph[node])if(distance[edge[0]]<distance[node])ways+=dfs(edge[0]);
        memo[node]=(ways%MOD).toInt();
        return memo[node]
    };
    fun countRestrictedPaths(n:Int,edges:Array<IntArray>):Int{
        target=n;
        graph=Array(n+1){
            mutableListOf()
        };
        for(edge in edges){
            graph[edge[0]].add(intArrayOf(edge[1],edge[2]));
            graph[edge[1]].add(intArrayOf(edge[0],edge[2]))
        };
        distance=LongArray(n+1){
            Long.MAX_VALUE
        };
        distance[n]=0;
        val queue=java.util.PriorityQueue<LongArray>(compareBy{
            it[0]
        });
        queue.add(longArrayOf(0,n.toLong()));
        while(queue.isNotEmpty()){
            val state=queue.remove();
            val node=state[1].toInt();
            if(state[0]!=distance[node])continue;
            for(edge in graph[node])if(distance[node]+edge[1]<distance[edge[0]]){
                distance[edge[0]]=distance[node]+edge[1];
                queue.add(longArrayOf(distance[edge[0]],edge[0].toLong()))
            }
        };
        memo=IntArray(n+1){
            -1
        };
        return dfs(1)
    }
}
