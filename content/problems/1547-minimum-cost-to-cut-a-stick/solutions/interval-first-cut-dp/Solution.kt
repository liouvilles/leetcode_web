class Solution {
    fun minCost(n:Int,cuts:IntArray):Int{
        val positions=intArrayOf(0,*cuts,n);
        positions.sort();
        val size=positions.size;
        val dp=Array(size){
            IntArray(size)
        };
        for(span in 2 until size)for(left in 0 until size-span){
            val right=left+span;
            dp[left][right]=Int.MAX_VALUE;
            for(middle in left+1 until right)dp[left][right]=minOf(dp[left][right],positions[right]-positions[left]+dp[left][middle]+dp[middle][right])
        };
        return dp[0][size-1]
    }
}
