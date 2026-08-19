class Solution {
    fun longestIdealString(s:String,k:Int):Int{
        val dp=IntArray(26);
        var answer=0;
        for(ch in s){
            val value=ch-'a';
            var best=0;
            for(previous in maxOf(0,value-k)..minOf(25,value+k))best=maxOf(best,dp[previous]);
            dp[value]=maxOf(dp[value],best+1);
            answer=maxOf(answer,dp[value])
        };
        return answer
    }
}
