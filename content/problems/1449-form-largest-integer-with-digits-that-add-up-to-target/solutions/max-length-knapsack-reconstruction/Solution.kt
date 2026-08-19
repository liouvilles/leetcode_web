class Solution {
    fun largestNumber(cost:IntArray,target:Int):String{
        val negative=-1_000_000;
        val dp=IntArray(target+1){
            negative
        };
        dp[0]=0;
        for(total in 1..target)for(digit in 1..9)if(total>=cost[digit-1]&&dp[total-cost[digit-1]]!=negative)dp[total]=maxOf(dp[total],dp[total-cost[digit-1]]+1);
        if(dp[target]<0)return "0";
        val answer=StringBuilder();
        var remaining=target;
        for(digit in 9 downTo 1)while(remaining>=cost[digit-1]&&dp[remaining]==dp[remaining-cost[digit-1]]+1){
            answer.append(digit);
            remaining-=cost[digit-1]
        };
        return answer.toString()
    }
}
