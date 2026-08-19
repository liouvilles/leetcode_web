class Solution {
    fun longestSquareStreak(nums:IntArray):Int{
        nums.sort();
        val dp=HashMap<Int,Int>();
        var answer=1;
        for(value in nums){
            val root=kotlin.math.sqrt(value.toDouble()).toInt();
            val length=if(root*root==value&&dp[root]!=null)dp[root]!!+1 else 1;
            dp[value]=length;
            answer=maxOf(answer,length)
        };
        return if(answer>=2)answer else -1
    }
}
