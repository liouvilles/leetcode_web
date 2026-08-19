class Solution {
    fun maximizeTheProfit(n:Int,offers:List<List<Int>>):Int{
        val sorted=offers.sortedBy{
            it[1]
        };
        val dp=IntArray(n+1);
        var index=0;
        for(end in 0 until n){
            dp[end+1]=maxOf(dp[end+1],dp[end]);
            while(index<sorted.size&&sorted[index][1]==end){
                val offer=sorted[index++];
                dp[end+1]=maxOf(dp[end+1],dp[offer[0]]+offer[2])
            }
        };
        return dp[n]
    }
}
