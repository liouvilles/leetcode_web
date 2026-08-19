class Solution {
    private lateinit var arr:IntArray;
    private lateinit var memo:IntArray;
    private var d=0;
    fun maxJumps(arr:IntArray,d:Int):Int{
        this.arr=arr;
        this.d=d;
        memo=IntArray(arr.size);
        return arr.indices.maxOf{
            dfs(it)
        }
    };
    private fun dfs(index:Int):Int{
        if(memo[index]!=0)return memo[index];
        var best=1;
        for(direction in intArrayOf(-1,1))for(step in 1..d){
            val next=index+direction*step;
            if(next !in arr.indices||arr[next]>=arr[index])break;
            best=maxOf(best,1+dfs(next))
        };
        memo[index]=best;
        return best
    }
}
