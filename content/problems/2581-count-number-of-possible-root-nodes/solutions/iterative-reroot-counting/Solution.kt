class Solution {
    private fun key(from:Int,to:Int)=(from.toLong() shl 32) xor (to.toLong() and 0xffffffffL);
    fun rootCount(edges:Array<IntArray>,guesses:Array<IntArray>,k:Int):Int{
        val n=edges.size+1;
        val graph=Array(n){
            mutableListOf<Int>()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        val guessed=HashSet<Long>();
        for(guess in guesses)guessed.add(key(guess[0],guess[1]));
        val parent=IntArray(n){
            -2
        };
        val order=IntArray(n);
        parent[0]=-1;
        var size=1;
        for(index in 0 until n){
            val node=order[index];
            for(next in graph[node])if(next!=parent[node]){
                parent[next]=node;
                order[size++]=next
            }
        };
        var rootScore=0;
        for(node in 1 until n)if(key(parent[node],node) in guessed)rootScore++;
        val score=IntArray(n);
        score[0]=rootScore;
        var answer=if(rootScore>=k)1 else 0;
        for(index in 1 until n){
            val node=order[index];
            val up=parent[node];
            score[node]=score[up]-(if(key(up,node) in guessed)1 else 0)+(if(key(node,up) in guessed)1 else 0);
            if(score[node]>=k)answer++
        };
        return answer
    }
}
