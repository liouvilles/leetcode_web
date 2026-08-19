class Solution {
    fun findSmallestSetOfVertices(n:Int,edges:List<List<Int>>):List<Int>{
        val indegree=IntArray(n);
        for(edge in edges)indegree[edge[1]]++;
        return (0 until n).filter{
            indegree[it]==0
        }
    }
}
