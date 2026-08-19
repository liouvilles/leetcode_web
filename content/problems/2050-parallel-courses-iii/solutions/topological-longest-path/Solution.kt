class Solution {
    fun minimumTime(n:Int,relations:Array<IntArray>,time:IntArray):Int{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        val indegree=IntArray(n);
        val finish=time.clone();
        for(relation in relations){
            graph[relation[0]-1].add(relation[1]-1);
            indegree[relation[1]-1]++
        };
        val queue=java.util.ArrayDeque<Int>();
        for(i in 0 until n)if(indegree[i]==0)queue.add(i);
        while(queue.isNotEmpty()){
            val course=queue.removeFirst();
            for(next in graph[course]){
                finish[next]=maxOf(finish[next],finish[course]+time[next]);
                if(--indegree[next]==0)queue.add(next)
            }
        };
        return finish.maxOrNull()!!
    }
}
