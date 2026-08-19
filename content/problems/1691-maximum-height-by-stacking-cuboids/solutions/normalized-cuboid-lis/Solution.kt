class Solution {
    fun maxHeight(cuboids:Array<IntArray>):Int{
        for(cuboid in cuboids)cuboid.sort();
        cuboids.sortWith(compareBy<IntArray>{
            it[0]
        }.thenBy{
            it[1]
        }.thenBy{
            it[2]
        });
        val dp=IntArray(cuboids.size);
        var answer=0;
        for(i in cuboids.indices){
            dp[i]=cuboids[i][2];
            for(j in 0 until i)if((0..2).all{
                cuboids[j][it]<=cuboids[i][it]
            })dp[i]=maxOf(dp[i],dp[j]+cuboids[i][2]);
            answer=maxOf(answer,dp[i])
        };
        return answer
    }
}
