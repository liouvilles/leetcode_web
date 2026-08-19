class Solution {
    fun validPartition(nums:IntArray):Boolean{
        val n=nums.size;
        val dp=BooleanArray(n+1);
        dp[0]=true;
        for(i in 2..n){
            if(dp[i-2]&&nums[i-2]==nums[i-1])dp[i]=true;
            if(i>=3&&dp[i-3]&&((nums[i-3]==nums[i-2]&&nums[i-2]==nums[i-1])||(nums[i-3]+1==nums[i-2]&&nums[i-2]+1==nums[i-1])))dp[i]=true
        };
        return dp[n]
    }
}
