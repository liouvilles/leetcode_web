class Solution {
    fun maxValueOfCoins(piles:List<List<Int>>,k:Int):Int{
        val negative=-1_000_000_000;
        var dp=IntArray(k+1){
            negative
        };
        dp[0]=0;
        for(pile in piles){
            val next=dp.clone();
            var prefix=0;
            for(take in 1..minOf(k,pile.size)){
                prefix+=pile[take-1];
                for(used in 0..k-take)if(dp[used]>negative)next[used+take]=maxOf(next[used+take],dp[used]+prefix)
            };
            dp=next
        };
        return dp[k]
    }
}
