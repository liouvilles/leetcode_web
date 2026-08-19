class Solution {
    fun countSquares(matrix:Array<IntArray>):Int{
        val rows=matrix.size;
        val columns=matrix[0].size;
        val dp=Array(rows+1){
            IntArray(columns+1)
        };
        var answer=0;
        for(r in 1..rows)for(c in 1..columns)if(matrix[r-1][c-1]==1){
            dp[r][c]=1+minOf(dp[r-1][c-1],dp[r-1][c],dp[r][c-1]);
            answer+=dp[r][c]
        };
        return answer
    }
}
