class Solution {
    public int mincostTickets(int[] days,int[] costs){
        int last=days[days.length-1];
        boolean[] travel=new boolean[last+1];
        for(int day:days)travel[day]=true;
        int[] dp=new int[last+1];
        for(int day=1;day<=last;day++)if(!travel[day])dp[day]=dp[day-1];
        else dp[day]=Math.min(dp[day-1]+costs[0],Math.min(dp[Math.max(0,day-7)]+costs[1],dp[Math.max(0,day-30)]+costs[2]));
        return dp[last];
    }
}
