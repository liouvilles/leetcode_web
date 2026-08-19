class Solution {
    fun combinationSum4(nums:IntArray,target:Int):Int{
        val dp=IntArray(target+1);
        dp[0]=1;
        for(sum in 1..target)for(value in nums)if(value<=sum)dp[sum]+=dp[sum-value];
        return dp[target]
    }
}
