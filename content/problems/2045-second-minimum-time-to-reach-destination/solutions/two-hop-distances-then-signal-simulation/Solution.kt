class Solution {
    fun secondMinimum(n:Int,edges:Array<IntArray>,time:Int,change:Int):Int{
        val graph=Array(n+1){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val infinity=1_000_000;
        val first=IntArray(n+1){
            infinity
        };
        val second=IntArray(n+1){
            infinity
        };
        val queue=java.util.ArrayDeque<IntArray>();
        first[1]=0;
        queue.add(intArrayOf(1,0));
        while(queue.isNotEmpty()){
            val state=queue.removeFirst();
            val node=state[0];
            val distance=state[1];
            for(next in graph[node]){
                val candidate=distance+1;
                if(candidate<first[next]){
                    second[next]=first[next];
                    first[next]=candidate;
                    queue.add(intArrayOf(next,candidate))
                }else if(candidate>first[next]&&candidate<second[next]){
                    second[next]=candidate;
                    queue.add(intArrayOf(next,candidate))
                }
            }
        };
        var current=0;
        repeat(second[n]){
            if((current/change)%2==1)current=(current/change+1)*change;
            current+=time
        };
        return current
    }
}
