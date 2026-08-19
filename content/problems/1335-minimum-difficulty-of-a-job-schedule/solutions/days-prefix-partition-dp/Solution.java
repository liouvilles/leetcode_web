class Solution {
    public int minDifficulty(int[] jobDifficulty,int d){
        int n=jobDifficulty.length;
        if(n<d)return -1;
        int infinity=1000000000;
        int[] dp=new int[n+1];
        Arrays.fill(dp,infinity);
        dp[0]=0;
        for(int day=1;day<=d;day++){
            int[] next=new int[n+1];
            Arrays.fill(next,infinity);
            for(int jobs=day;jobs<=n;jobs++){
                int maximum=0;
                for(int split=jobs-1;split>=day-1;split--){
                    maximum=Math.max(maximum,jobDifficulty[split]);
                    next[jobs]=Math.min(next[jobs],dp[split]+maximum);
                }
            }
            dp=next;
        }
        return dp[n];
    }
}
