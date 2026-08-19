class Solution {
    fun maxDotProduct(nums1:IntArray,nums2:IntArray):Int{
        val negative=-1_000_000_000;
        val dp=Array(nums1.size+1){
            IntArray(nums2.size+1){
                negative
            }
        };
        for(i in 1..nums1.size)for(j in 1..nums2.size){
            val product=nums1[i-1]*nums2[j-1];
            dp[i][j]=maxOf(product,product+maxOf(0,dp[i-1][j-1]),dp[i-1][j],dp[i][j-1])
        };
        return dp[nums1.size][nums2.size]
    }
}
