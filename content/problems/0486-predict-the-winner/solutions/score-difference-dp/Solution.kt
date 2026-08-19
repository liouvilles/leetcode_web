class Solution {
    fun predictTheWinner(nums:IntArray):Boolean{
        val n=nums.size;
        val dp=Array(n){
            IntArray(n)
        };
        for(i in nums.indices)dp[i][i]=nums[i];
        for(length in 2..n)for(left in 0..n-length){
            val right=left+length-1;
            dp[left][right]=maxOf(nums[left]-dp[left+1][right],nums[right]-dp[left][right-1])
        };
        return dp[0][n-1]>=0
    }
}
