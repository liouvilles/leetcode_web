class Solution {
    fun countPaths(grid:Array<IntArray>):Int{
        val mod=1_000_000_007L;
        val rows=grid.size;
        val columns=grid[0].size;
        val total=rows*columns;
        val order=(0 until total).sortedBy{
            grid[it/columns][it%columns]
        };
        val dp=LongArray(total){
            1
        };
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        var answer=0L;
        for(index in order){
            val row=index/columns;
            val column=index%columns;
            for(direction in directions){
                val r=row+direction[0];
                val c=column+direction[1];
                if(r in 0 until rows&&c in 0 until columns&&grid[r][c]<grid[row][column])dp[index]=(dp[index]+dp[r*columns+c])%mod
            };
            answer=(answer+dp[index])%mod
        };
        return answer.toInt()
    }
}
