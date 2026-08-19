class Solution {
    fun numberOfGoodPaths(vals:IntArray,edges:Array<IntArray>):Int{
        val n=vals.size;
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val order=vals.indices.sortedBy{
            vals[it]
        };
        val parent=IntArray(n){
            it
        };
        val size=IntArray(n){
            1
        };
        val active=BooleanArray(n);
        fun find(value:Int):Int{
            var x=value;
            while(parent[x]!=x){
                parent[x]=parent[parent[x]];
                x=parent[x]
            };
            return x
        };
        fun union(x:Int,y:Int){
            var a=find(x);
            var b=find(y);
            if(a==b)return;
            if(size[a]<size[b]){
                val t=a;
                a=b;
                b=t
            };
            parent[b]=a;
            size[a]+=size[b]
        };
        var answer=n;
        var start=0;
        while(start<n){
            var end=start;
            while(end<n&&vals[order[end]]==vals[order[start]])end++;
            for(p in start until end){
                val node=order[p];
                active[node]=true;
                for(next in graph[node])if(active[next])union(node,next)
            };
            val count=HashMap<Int,Int>();
            for(p in start until end){
                val root=find(order[p]);
                count[root]=(count[root]?:0)+1
            };
            for(c in count.values)answer+=c*(c-1)/2;
            start=end
        };
        return answer
    }
}
