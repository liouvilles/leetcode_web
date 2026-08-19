class Solution {
    private class DSU(n:Int){
        val parent=IntArray(n+1){
            it
        };
        val rank=IntArray(n+1);
        fun find(value:Int):Int{
            if(parent[value]!=value)parent[value]=find(parent[value]);
            return parent[value]
        };
        fun union(first:Int,second:Int){
            var a=find(first);
            var b=find(second);
            if(a==b)return;
            if(rank[a]<rank[b]){
                val temporary=a;
                a=b;
                b=temporary
            };
            parent[b]=a;
            if(rank[a]==rank[b])rank[a]++
        }
    };
    fun areConnected(n:Int,threshold:Int,queries:Array<IntArray>):List<Boolean>{
        val dsu=DSU(n);
        for(factor in threshold+1..n)for(multiple in factor*2..n step factor)dsu.union(factor,multiple);
        return queries.map{
            dsu.find(it[0])==dsu.find(it[1])
        }
    }
}
