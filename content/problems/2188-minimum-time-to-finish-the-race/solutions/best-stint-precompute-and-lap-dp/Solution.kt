class Solution {
    fun minimumFinishTime(tires:Array<IntArray>,changeTime:Int,numLaps:Int):Int{
        val infinity=Long.MAX_VALUE/4;
        val best=LongArray(numLaps+1){
            infinity
        };
        val fastest=tires.minOf{
            it[0]
        };
        for(tire in tires){
            var lap=tire[0].toLong();
            var total=0L;
            var run=1;
            while(run<=numLaps&&lap<=fastest+changeTime){
                total+=lap;
                best[run]=minOf(best[run],total);
                if(lap>infinity/tire[1])break;
                lap*=tire[1];
                run++
            }
        };
        val dp=LongArray(numLaps+1){
            infinity
        };
        dp[0]=-changeTime.toLong();
        for(laps in 1..numLaps)for(run in 1..laps)if(best[run]<infinity)dp[laps]=minOf(dp[laps],dp[laps-run]+changeTime+best[run]);
        return dp[numLaps].toInt()
    }
}
