class Solution {
    fun jobScheduling(startTime:IntArray,endTime:IntArray,profit:IntArray):Int{
        val jobs=startTime.indices.map{
            intArrayOf(startTime[it],endTime[it],profit[it])
        }.sortedBy{
            it[0]
        };
        val starts=jobs.map{
            it[0]
        };
        val dp=IntArray(jobs.size+1);
        for(i in jobs.lastIndex downTo 0){
            var left=0;
            var right=jobs.size;
            while(left<right){
                val middle=(left+right)/2;
                if(starts[middle]<jobs[i][1])left=middle+1 else right=middle
            };
            dp[i]=maxOf(dp[i+1],jobs[i][2]+dp[left])
        };
        return dp[0]
    }
}
