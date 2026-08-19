class Solution {
    fun largestSumOfAverages(nums:IntArray,k:Int):Double{
        val n=nums.size;
        val prefix=DoubleArray(n+1);
        var dp=DoubleArray(n+1);
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i];
        for(i in 1..n)dp[i]=prefix[i]/i;
        for(group in 2..k){
            val next=DoubleArray(n+1);
            for(i in group..n)for(cut in group-1 until i)next[i]=maxOf(next[i],dp[cut]+(prefix[i]-prefix[cut])/(i-cut));
            dp=next
        };
        return dp[n]
    }
}
