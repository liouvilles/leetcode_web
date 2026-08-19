class Solution {
    fun bestTeamScore(scores:IntArray,ages:IntArray):Int{
        val players=scores.indices.map{
            intArrayOf(ages[it],scores[it])
        }.sortedWith(compareBy<IntArray>{
            it[0]
        }.thenBy{
            it[1]
        });
        val dp=IntArray(scores.size);
        var answer=0;
        for(i in players.indices){
            dp[i]=players[i][1];
            for(j in 0 until i)if(players[j][1]<=players[i][1])dp[i]=maxOf(dp[i],dp[j]+players[i][1]);
            answer=maxOf(answer,dp[i])
        };
        return answer
    }
}
