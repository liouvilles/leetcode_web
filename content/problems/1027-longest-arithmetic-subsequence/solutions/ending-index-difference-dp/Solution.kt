class Solution {
    fun longestArithSeqLength(nums:IntArray):Int{
        val dp=List(nums.size){
            mutableMapOf<Int,Int>()
        };
        var answer=2;
        for(i in nums.indices)for(j in 0 until i){
            val difference=nums[i]-nums[j];
            val length=(dp[j][difference]?:1)+1;
            dp[i][difference]=maxOf(dp[i][difference]?:0,length);
            answer=maxOf(answer,length)
        };
        return answer
    }
}
