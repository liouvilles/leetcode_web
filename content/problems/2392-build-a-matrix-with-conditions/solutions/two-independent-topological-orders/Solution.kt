class Solution {
    private fun positions(k:Int,conditions:Array<IntArray>):IntArray?{
        val graph=Array(k+1){
            mutableListOf<Int>()
        };
        val indegree=IntArray(k+1);
        for(edge in conditions){
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++
        };
        val queue=java.util.ArrayDeque<Int>();
        for(value in 1..k)if(indegree[value]==0)queue.add(value);
        val position=IntArray(k+1);
        var count=0;
        while(queue.isNotEmpty()){
            val value=queue.removeFirst();
            position[value]=count++;
            for(next in graph[value])if(--indegree[next]==0)queue.add(next)
        };
        return if(count==k)position else null
    };
    fun buildMatrix(k:Int,rowConditions:Array<IntArray>,colConditions:Array<IntArray>):Array<IntArray>{
        val rows=positions(k,rowConditions)?:return emptyArray();
        val columns=positions(k,colConditions)?:return emptyArray();
        val answer=Array(k){
            IntArray(k)
        };
        for(value in 1..k)answer[rows[value]][columns[value]]=value;
        return answer
    }
}
