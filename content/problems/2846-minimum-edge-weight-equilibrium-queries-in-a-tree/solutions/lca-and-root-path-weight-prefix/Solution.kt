class Solution {
    fun minOperationsQueries(n:Int,edges:Array<IntArray>,queries:Array<IntArray>):IntArray{
        val graph=List(n){
            mutableListOf<IntArray>()
        };
        for(edge in edges){
            graph[edge[0]].add(intArrayOf(edge[1],edge[2]-1));
            graph[edge[1]].add(intArrayOf(edge[0],edge[2]-1))
        };
        var levels=1;
        while((1 shl levels)<=n)levels++;
        val up=Array(levels){
            IntArray(n)
        };
        val prefix=Array(n){
            IntArray(26)
        };
        val depth=IntArray(n);
        java.util.Arrays.fill(up[0],-1);
        up[0][0]=0;
        val queue=java.util.ArrayDeque<Int>();
        queue.addLast(0);
        while(!queue.isEmpty()){
            val node=queue.pollFirst();
            for(edge in graph[node]){
                val next=edge[0];
                if(next==up[0][node])continue;
                up[0][next]=node;
                depth[next]=depth[node]+1;
                prefix[next]=prefix[node].clone();
                prefix[next][edge[1]]++;
                queue.addLast(next)
            }
        };
        for(bit in 1 until levels)for(node in 0 until n)up[bit][node]=up[bit-1][up[bit-1][node]];
        fun lca(first:Int,second:Int):Int{
            var a=first;
            var b=second;
            if(depth[a]<depth[b]){
                val swap=a;
                a=b;
                b=swap
            };
            val difference=depth[a]-depth[b];
            for(bit in 0 until levels)if((difference shr bit and 1)==1)a=up[bit][a];
            if(a==b)return a;
            for(bit in levels-1 downTo 0)if(up[bit][a]!=up[bit][b]){
                a=up[bit][a];
                b=up[bit][b]
            };
            return up[0][a]
        };
        return IntArray(queries.size){
            i->val u=queries[i][0];
            val v=queries[i][1];
            val ancestor=lca(u,v);
            val length=depth[u]+depth[v]-2*depth[ancestor];
            var maximum=0;
            for(weight in 0 until 26)maximum=maxOf(maximum,prefix[u][weight]+prefix[v][weight]-2*prefix[ancestor][weight]);
            length-maximum
        }
    }
}
