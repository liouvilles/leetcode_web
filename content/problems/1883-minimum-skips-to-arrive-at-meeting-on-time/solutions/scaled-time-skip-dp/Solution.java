class Solution {
    public int minSkips(int[] dist,int speed,int hoursBefore){
        long infinity=Long.MAX_VALUE/4;
        long[] dp=new long[dist.length+1];
        Arrays.fill(dp,infinity);
        dp[0]=0;
        for(int road=0;road<dist.length;road++){
            long[] next=new long[dist.length+1];
            Arrays.fill(next,infinity);
            for(int skipped=0;skipped<=road;skipped++)if(dp[skipped]<infinity){
                long arrival=dp[skipped]+dist[road];
                long waited=road==dist.length-1?arrival:(arrival+speed-1)/speed*speed;
                next[skipped]=Math.min(next[skipped],waited);
                if(road<dist.length-1)next[skipped+1]=Math.min(next[skipped+1],arrival);
            }
            dp=next;
        }
        long limit=(long)hoursBefore*speed;
        for(int skipped=0;skipped<=dist.length;skipped++)if(dp[skipped]<=limit)return skipped;
        return -1;
    }
}
