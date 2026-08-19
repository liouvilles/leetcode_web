class Solution {
    fun restoreArray(adjacentPairs:Array<IntArray>):IntArray{
        val graph=mutableMapOf<Int,MutableList<Int>>();
        for(pair in adjacentPairs){
            graph.getOrPut(pair[0]){
                mutableListOf()
            }.add(pair[1]);
            graph.getOrPut(pair[1]){
                mutableListOf()
            }.add(pair[0])
        };
        val answer=IntArray(graph.size);
        answer[0]=adjacentPairs.asSequence().flatMap{
            it.asSequence()
        }.first{
            graph[it]!!.size==1
        };
        for(i in 1 until answer.size){
            val neighbors=graph[answer[i-1]]!!;
            answer[i]=neighbors[0];
            if(i>1&&answer[i]==answer[i-2])answer[i]=neighbors[1]
        };
        return answer
    }
}
