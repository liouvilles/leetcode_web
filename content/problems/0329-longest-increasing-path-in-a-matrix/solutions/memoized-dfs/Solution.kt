class Solution {
    fun longestIncreasingPath(matrix:Array<IntArray>):Int{
        val rows=matrix.size;
        val cols=matrix[0].size;
        val memo=Array(rows){
            IntArray(cols)
        };
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        fun dfs(r:Int,c:Int):Int{
            if(memo[r][c]!=0)return memo[r][c];
            var best=1;
            for(d in directions){
                val nr=r+d[0];
                val nc=c+d[1];
                if(nr in 0 until rows&&nc in 0 until cols&&matrix[nr][nc]>matrix[r][c])best=maxOf(best,1+dfs(nr,nc))
            };
            memo[r][c]=best;
            return best
        };
        var answer=0;
        for(r in 0 until rows)for(c in 0 until cols)answer=maxOf(answer,dfs(r,c));
        return answer
    }
}
