class Solution {
    fun numSimilarGroups(strs:Array<String>):Int{
        val dsu=DSU(strs.size);
        for(i in strs.indices)for(j in i+1 until strs.size)if(similar(strs[i],strs[j]))dsu.union(i,j);
        return dsu.groups
    };
    private fun similar(a:String,b:String):Boolean{
        var differences=0;
        for(i in a.indices)if(a[i]!=b[i]&&++differences>2)return false;
        return true
    };
    private class DSU(n:Int){
        val parent=IntArray(n){
            it
        };
        var groups=n;
        fun find(x:Int):Int{
            if(parent[x]!=x)parent[x]=find(parent[x]);
            return parent[x]
        };
        fun union(first:Int,second:Int){
            val a=find(first);
            val b=find(second);
            if(a!=b){
                parent[b]=a;
                groups--
            }
        }
    }
}
