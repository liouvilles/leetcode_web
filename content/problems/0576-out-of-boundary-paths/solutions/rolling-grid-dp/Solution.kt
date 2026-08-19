class Solution {
    fun findPaths(m:Int,n:Int,maxMove:Int,startRow:Int,startColumn:Int):Int{
        val mod=1000000007L;
        var answer=0L;
        var dp=Array(m){
            LongArray(n)
        };
        dp[startRow][startColumn]=1;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        repeat(maxMove){
            val next=Array(m){
                LongArray(n)
            };
            for(row in 0 until m)for(column in 0 until n)for(direction in directions){
                val r=row+direction[0];
                val c=column+direction[1];
                if(r !in 0 until m||c !in 0 until n)answer=(answer+dp[row][column])%mod else next[r][c]=(next[r][c]+dp[row][column])%mod
            };
            dp=next
        };
        return answer.toInt()
    }
}
