class Solution {
    fun longestSubsequence(arr:IntArray,difference:Int):Int{
        val dp=mutableMapOf<Int,Int>();
        var answer=0;
        for(value in arr){
            val length=(dp[value-difference]?:0)+1;
            dp[value]=maxOf(dp[value]?:0,length);
            answer=maxOf(answer,length)
        };
        return answer
    }
}
