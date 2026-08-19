class Solution {
    private lateinit var cost:Array<IntArray>;
    private lateinit var memo:Array<IntArray>;
    private var n=0;
    fun palindromePartition(s:String,k:Int):Int{
        n=s.length;
        cost=Array(n){
            IntArray(n)
        };
        for(length in 2..n)for(left in 0..n-length){
            val right=left+length-1;
            cost[left][right]=(if(length>2)cost[left+1][right-1] else 0)+if(s[left]==s[right])0 else 1
        };
        memo=Array(n){
            IntArray(k+1){
                -1
            }
        };
        return dfs(0,k)
    };
    private fun dfs(index:Int,parts:Int):Int{
        if(parts==1)return cost[index][n-1];
        if(memo[index][parts]>=0)return memo[index][parts];
        var best=1000000;
        for(end in index..n-parts)best=minOf(best,cost[index][end]+dfs(end+1,parts-1));
        memo[index][parts]=best;
        return best
    }
}
