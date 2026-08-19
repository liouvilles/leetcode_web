class Solution {
    private List<int[]> extras,zeros;
    private int[] memo;
    private int dfs(int mask){
        int index=Integer.bitCount(mask);
        if(index==extras.size())return 0;
        if(memo[mask]!=-1)return memo[mask];
        int answer=1000000;
        for(int target=0;target<zeros.size();target++)if((mask&(1<<target))==0){
            int distance=Math.abs(extras.get(index)[0]-zeros.get(target)[0])+Math.abs(extras.get(index)[1]-zeros.get(target)[1]);
            answer=Math.min(answer,distance+dfs(mask|1<<target));
        }
        return memo[mask]=answer;
    }
    public int minimumMoves(int[][] grid){
        extras=new ArrayList<>();
        zeros=new ArrayList<>();
        for(int row=0;row<3;row++)for(int col=0;col<3;col++){
            if(grid[row][col]==0)zeros.add(new int[]{
                row,col
            });
            for(int count=1;count<grid[row][col];count++)extras.add(new int[]{
                row,col
            });
        }
        memo=new int[1<<zeros.size()];
        Arrays.fill(memo,-1);
        return dfs(0);
    }
}
