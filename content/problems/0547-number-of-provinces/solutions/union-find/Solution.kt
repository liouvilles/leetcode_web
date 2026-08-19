class Solution {
    fun findCircleNum(isConnected:Array<IntArray>):Int{
        val n=isConnected.size;
        val parent=IntArray(n){
            it
        };
        val rank=IntArray(n);
        fun find(value:Int):Int{
            if(parent[value]!=value)parent[value]=find(parent[value]);
            return parent[value]
        };
        var components=n;
        for(i in 0 until n)for(j in i+1 until n)if(isConnected[i][j]==1){
            var a=find(i);
            var b=find(j);
            if(a!=b){
                if(rank[a]<rank[b]){
                    val value=a;
                    a=b;
                    b=value
                };
                parent[b]=a;
                if(rank[a]==rank[b])rank[a]++;
                components--
            }
        };
        return components
    }
}
