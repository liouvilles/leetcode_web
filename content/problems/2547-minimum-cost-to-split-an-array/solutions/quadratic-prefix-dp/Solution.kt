class Solution {
    fun minCost(nums:IntArray,k:Int):Int{
        val n=nums.size;
        val dp=IntArray(n+1){
            Int.MAX_VALUE/2
        };
        dp[0]=0;
        for(left in 0 until n){
            val frequency=IntArray(n+1);
            var trimmed=0;
            for(right in left until n){
                val value=nums[right];
                frequency[value]++;
                if(frequency[value]==2)trimmed+=2 else if(frequency[value]>2)trimmed++;
                dp[right+1]=minOf(dp[right+1],dp[left]+k+trimmed)
            }
        };
        return dp[n]
    }
}
