class Solution {
    public long minimumTotalDistance(List<Integer> robot,int[][] factory){
        Collections.sort(robot);
        Arrays.sort(factory,Comparator.comparingInt(a->a[0]));
        int m=robot.size();
        long inf=Long.MAX_VALUE/4;
        long[] dp=new long[m+1];
        Arrays.fill(dp,inf);
        dp[0]=0;
        for(int[] current:factory){
            long[] next=dp.clone();
            for(int i=1;i<=m;i++){
                long distance=0;
                for(int take=1;take<=current[1]&&take<=i;take++){
                    distance+=Math.abs((long)robot.get(i-take)-current[0]);
                    if(dp[i-take]<inf)next[i]=Math.min(next[i],dp[i-take]+distance);
                }
            }
            dp=next;
        }
        return dp[m];
    }
}
