class Solution {
    fun countPairsOfConnectableServers(edges:Array<IntArray>,signalSpeed:Int):IntArray{
        val n=edges.size+1
        val graph=Array(n){mutableListOf<IntArray>()}
        for(edge in edges){graph[edge[0]].add(intArrayOf(edge[1],edge[2]));graph[edge[1]].add(intArrayOf(edge[0],edge[2]))}
        fun count(node:Int,parent:Int,distance:Long):Int{
            var result=if(distance%signalSpeed==0L)1 else 0
            for(edge in graph[node])if(edge[0]!=parent)result+=count(edge[0],node,distance+edge[1])
            return result
        }
        val answer=IntArray(n)
        for(server in 0 until n){
            var previous=0
            for(edge in graph[server]){
                val current=count(edge[0],server,edge[1].toLong())
                answer[server]+=previous*current
                previous+=current
            }
        }
        return answer
    }
}
