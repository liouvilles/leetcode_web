class Solution {
    fun maxSelectedElements(nums:IntArray):Int{
        nums.sort();
        val dp=IntArray(nums.last()+2);
        var answer=0;
        for(value in nums){
            dp[value+1]=maxOf(dp[value+1],dp[value]+1);
            dp[value]=maxOf(dp[value],dp[value-1]+1);
            answer=maxOf(answer,dp[value],dp[value+1])
        };
        return answer
    }
}
