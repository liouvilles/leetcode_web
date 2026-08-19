class Solution {
    fun minSideJumps(obstacles:IntArray):Int{
        val inf=1_000_000;
        val dp=intArrayOf(1,0,1);
        for(position in 1 until obstacles.size){
            if(obstacles[position]>0)dp[obstacles[position]-1]=inf;
            val minimum=dp.minOrNull()!!;
            for(lane in 0 until 3)if(obstacles[position]!=lane+1)dp[lane]=minOf(dp[lane],minimum+1)
        };
        return dp.minOrNull()!!
    }
}
