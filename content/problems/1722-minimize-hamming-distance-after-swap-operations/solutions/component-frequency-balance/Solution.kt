class Solution {
    private class DSU(n:Int){
        val parent=IntArray(n){
            it
        };
        val rank=IntArray(n);
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
    fun minimumHammingDistance(source:IntArray,target:IntArray,allowedSwaps:Array<IntArray>):Int{
        val dsu=DSU(source.size);
        for(edge in allowedSwaps)dsu.union(edge[0],edge[1]);
        val difference=mutableMapOf<Int,MutableMap<Int,Int>>();
        for(i in source.indices){
            val counts=difference.getOrPut(dsu.find(i)){
                mutableMapOf()
            };
            counts[source[i]]=(counts[source[i]]?:0)+1;
            counts[target[i]]=(counts[target[i]]?:0)-1
        };
        return difference.values.sumOf{
            counts->counts.values.filter{
                it>0
            }.sum()
        }
    }
}
