class Solution {
    public int minimumFinishTime(int[][] tires,int changeTime,int numLaps){
        long infinity=Long.MAX_VALUE/4;
        long[] best=new long[numLaps+1];
        Arrays.fill(best,infinity);
        int fastest=Integer.MAX_VALUE;
        for(int[] tire:tires)fastest=Math.min(fastest,tire[0]);
        for(int[] tire:tires){
            long lap=tire[0],total=0;
            for(int run=1;run<=numLaps&&lap<=fastest+changeTime;run++){
                total+=lap;
                best[run]=Math.min(best[run],total);
                if(lap>infinity/tire[1])break;
                lap*=tire[1];
            }
        }
        long[] dp=new long[numLaps+1];
        Arrays.fill(dp,infinity);
        dp[0]=-changeTime;
        for(int laps=1;laps<=numLaps;laps++)for(int run=1;run<=laps&&best[run]<infinity;run++)dp[laps]=Math.min(dp[laps],dp[laps-run]+changeTime+best[run]);
        return (int)dp[numLaps];
    }
}
