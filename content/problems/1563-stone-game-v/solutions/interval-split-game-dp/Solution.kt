class Solution {
    fun stoneGameV(stoneValue:IntArray):Int{
        val n=stoneValue.size;
        val prefix=IntArray(n+1);
        for(i in stoneValue.indices)prefix[i+1]=prefix[i]+stoneValue[i];
        val dp=Array(n){
            IntArray(n)
        };
        for(length in 2..n)for(left in 0..n-length){
            val right=left+length-1;
            for(split in left until right){
                val leftSum=prefix[split+1]-prefix[left];
                val rightSum=prefix[right+1]-prefix[split+1];
                val candidate=if(leftSum<rightSum)leftSum+dp[left][split]else if(leftSum>rightSum)rightSum+dp[split+1][right]else leftSum+maxOf(dp[left][split],dp[split+1][right]);
                dp[left][right]=maxOf(dp[left][right],candidate)
            }
        };
        return dp[0][n-1]
    }
}
