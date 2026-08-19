class Solution {
    fun knightProbability(n:Int,k:Int,row:Int,column:Int):Double{
        var dp=Array(n){
            DoubleArray(n)
        };
        dp[row][column]=1.0;
        val moves=arrayOf(intArrayOf(1,2),intArrayOf(1,-2),intArrayOf(-1,2),intArrayOf(-1,-2),intArrayOf(2,1),intArrayOf(2,-1),intArrayOf(-2,1),intArrayOf(-2,-1));
        repeat(k){
            val next=Array(n){
                DoubleArray(n)
            };
            for(r in 0 until n)for(c in 0 until n)for(move in moves){
                val nr=r+move[0];
                val nc=c+move[1];
                if(nr in 0 until n&&nc in 0 until n)next[nr][nc]+=dp[r][c]/8
            };
            dp=next
        };
        return dp.sumOf{
            it.sum()
        }
    }
}
