class Solution {
    fun leftmostBuildingQueries(heights:IntArray,queries:Array<IntArray>):IntArray{
        val waiting=Array(heights.size){
            mutableListOf<IntArray>()
        };
        val answer=IntArray(queries.size){
            -1
        };
        for(index in queries.indices){
            val left=minOf(queries[index][0],queries[index][1]);
            val right=maxOf(queries[index][0],queries[index][1]);
            if(left==right||heights[left]<heights[right])answer[index]=right else waiting[right].add(intArrayOf(heights[left],index))
        };
        val pending=java.util.PriorityQueue<IntArray>(compareBy<IntArray>{
            it[0]
        });
        for(building in heights.indices){
            while(pending.isNotEmpty()&&pending.peek()[0]<heights[building]){
                val query=pending.poll();
                answer[query[1]]=building
            };
            for(query in waiting[building])pending.add(query)
        };
        return answer
    }
}
