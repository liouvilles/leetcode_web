class Solution {
    fun componentValue(nums:IntArray,edges:Array<IntArray>):Int{
        val n=nums.size;
        val total=nums.sum();
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        for(components in n downTo 1)if(total%components==0){
            val target=total/components;
            var valid=true;
            fun dfs(node:Int,parent:Int):Int{
                var sum=nums[node];
                for(next in graph[node])if(next!=parent)sum+=dfs(next,node);
                if(sum>target)valid=false;
                return if(sum==target)0 else sum
            };
            if(dfs(0,-1)==0&&valid)return components-1
        };
        return 0
    }
}
