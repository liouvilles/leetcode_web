class Solution {
    fun minScoreTriangulation(values:IntArray):Int{
        val n=values.size;
        val dp=Array(n){
            IntArray(n)
        };
        for(length in 3..n)for(left in 0..n-length){
            val right=left+length-1;
            dp[left][right]=Int.MAX_VALUE;
            for(middle in left+1 until right)dp[left][right]=minOf(dp[left][right],dp[left][middle]+dp[middle][right]+values[left]*values[middle]*values[right])
        };
        return dp[0][n-1]
    }
}
