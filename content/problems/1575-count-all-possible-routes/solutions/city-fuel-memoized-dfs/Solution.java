class Solution {
    private int[] locations;
    private int finish;
    private int[][] memo;
    private static final int MOD=1_000_000_007;
    private int dfs(int city,int fuel){
        if(memo[city][fuel]!=-1)return memo[city][fuel];
        long answer=city==finish?1:0;
        for(int next=0;next<locations.length;next++)if(next!=city){
            int cost=Math.abs(locations[city]-locations[next]);
            if(cost<=fuel)answer+=dfs(next,fuel-cost);
        }
        return memo[city][fuel]=(int)(answer%MOD);
    }
    public int countRoutes(int[] locations,int start,int finish,int fuel){
        this.locations=locations;
        this.finish=finish;
        memo=new int[locations.length][fuel+1];
        for(int[] row:memo)Arrays.fill(row,-1);
        return dfs(start,fuel);
    }
}
