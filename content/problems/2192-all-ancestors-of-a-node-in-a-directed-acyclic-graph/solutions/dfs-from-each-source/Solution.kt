class Solution {
    fun getAncestors(n:Int,edges:Array<IntArray>):List<List<Int>>{
        val graph=Array(n){
            mutableListOf<Int>()
        };
        val answer=List(n){
            mutableListOf<Int>()
        };
        for(edge in edges)graph[edge[0]].add(edge[1]);
        for(source in 0 until n){
            val seen=BooleanArray(n);
            val stack=java.util.ArrayDeque<Int>();
            graph[source].forEach{
                stack.add(it)
            };
            while(stack.isNotEmpty()){
                val node=stack.removeLast();
                if(seen[node])continue;
                seen[node]=true;
                answer[node].add(source);
                for(next in graph[node])stack.add(next)
            }
        };
        return answer
    }
}
