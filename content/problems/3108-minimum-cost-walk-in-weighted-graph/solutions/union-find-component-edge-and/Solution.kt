class Solution {
    private class UnionFind(n:Int){
        private val parent=IntArray(n){it}
        private val size=IntArray(n){1}
        fun find(node:Int):Int{if(parent[node]!=node)parent[node]=find(parent[node]);return parent[node]}
        fun union(first:Int,second:Int){var a=find(first);var b=find(second);if(a==b)return;if(size[a]<size[b]){val temporary=a;a=b;b=temporary};parent[b]=a;size[a]+=size[b]}
    }
    fun minimumCost(n:Int,edges:Array<IntArray>,query:Array<IntArray>):IntArray{
        val unionFind=UnionFind(n)
        for(edge in edges)unionFind.union(edge[0],edge[1])
        val componentCost=IntArray(n){-1}
        for(edge in edges){val root=unionFind.find(edge[0]);componentCost[root]=componentCost[root] and edge[2]}
        return IntArray(query.size){index->
            val first=unionFind.find(query[index][0]);val second=unionFind.find(query[index][1])
            if(first==second)componentCost[first] else -1
        }
    }
}
