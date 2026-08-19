class Solution {
    public int minSideJumps(int[] obstacles){
        int inf=1_000_000;
        int[] dp={
            1,0,1
        };
        for(int position=1;position<obstacles.length;position++){
            if(obstacles[position]>0)dp[obstacles[position]-1]=inf;
            int minimum=Math.min(dp[0],Math.min(dp[1],dp[2]));
            for(int lane=0;lane<3;lane++)if(obstacles[position]!=lane+1)dp[lane]=Math.min(dp[lane],minimum+1);
        }
        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }
}
