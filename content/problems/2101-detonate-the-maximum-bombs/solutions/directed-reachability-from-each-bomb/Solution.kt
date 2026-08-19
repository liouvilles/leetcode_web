class Solution {
    fun maximumDetonation(bombs:Array<IntArray>):Int{
        val n=bombs.size;
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(i in 0 until n)for(j in 0 until n){
            val dx=bombs[i][0].toLong()-bombs[j][0];
            val dy=bombs[i][1].toLong()-bombs[j][1];
            if(dx*dx+dy*dy<=bombs[i][2].toLong()*bombs[i][2])graph[i].add(j)
        };
        var answer=0;
        for(start in 0 until n){
            val visited=BooleanArray(n);
            val stack=java.util.ArrayDeque<Int>();
            stack.push(start);
            visited[start]=true;
            var count=0;
            while(stack.isNotEmpty()){
                val node=stack.pop();
                count++;
                for(next in graph[node])if(!visited[next]){
                    visited[next]=true;
                    stack.push(next)
                }
            };
            answer=maxOf(answer,count)
        };
        return answer
    }
}
