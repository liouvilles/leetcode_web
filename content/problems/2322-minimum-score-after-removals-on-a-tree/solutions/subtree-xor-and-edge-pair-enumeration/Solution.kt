class Solution {
    fun minimumScore(nums:IntArray,edges:Array<IntArray>):Int{
        val n=nums.size;
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val tin=IntArray(n);
        val tout=IntArray(n);
        val xor=IntArray(n);
        var timer=0;
        fun dfs(node:Int,parent:Int){
            tin[node]=timer++;
            xor[node]=nums[node];
            for(next in graph[node])if(next!=parent){
                dfs(next,node);
                xor[node]=xor[node] xor xor[next]
            };
            tout[node]=timer
        };
        dfs(0,-1);
        val ancestor={
            a:Int,b:Int->tin[a]<=tin[b]&&tout[b]<=tout[a]
        };
        val total=xor[0];
        var answer=Int.MAX_VALUE;
        for(a in 1 until n)for(b in a+1 until n){
            val x:Int;
            val y:Int;
            val z:Int;
            if(ancestor(a,b)){
                x=xor[b];
                y=xor[a] xor xor[b];
                z=total xor xor[a]
            }else if(ancestor(b,a)){
                x=xor[a];
                y=xor[b] xor xor[a];
                z=total xor xor[b]
            }else{
                x=xor[a];
                y=xor[b];
                z=total xor xor[a] xor xor[b]
            };
            answer=minOf(answer,maxOf(x,y,z)-minOf(x,y,z))
        };
        return answer
    }
}
