class Solution {
    fun minimumTotalDistance(robot:List<Int>,factory:Array<IntArray>):Long{
        val robots=robot.sorted();
        factory.sortBy{
            it[0]
        };
        val m=robots.size;
        val inf=Long.MAX_VALUE/4;
        var dp=LongArray(m+1){
            inf
        };
        dp[0]=0;
        for(current in factory){
            val next=dp.clone();
            for(i in 1..m){
                var distance=0L;
                for(take in 1..minOf(current[1],i)){
                    distance+=kotlin.math.abs(robots[i-take].toLong()-current[0]);
                    if(dp[i-take]<inf)next[i]=minOf(next[i],dp[i-take]+distance)
                }
            };
            dp=next
        };
        return dp[m]
    }
}
