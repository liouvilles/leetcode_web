class Solution {
    private static final int MOD=1_000_000_007;
    private int rows,cols;
    private int[][] apples;
    private int[][][] memo;
    private int dfs(int row,int col,int cuts){
        if(apples[row][col]==0)return 0;
        if(cuts==0)return 1;
        if(memo[row][col][cuts]!=-1)return memo[row][col][cuts];
        long answer=0;
        for(int nextRow=row+1;nextRow<rows;nextRow++)if(apples[row][col]-apples[nextRow][col]>0)answer+=dfs(nextRow,col,cuts-1);
        for(int nextCol=col+1;nextCol<cols;nextCol++)if(apples[row][col]-apples[row][nextCol]>0)answer+=dfs(row,nextCol,cuts-1);
        return memo[row][col][cuts]=(int)(answer%MOD);
    }
    public int ways(String[] pizza,int k){
        rows=pizza.length;
        cols=pizza[0].length();
        apples=new int[rows+1][cols+1];
        for(int row=rows-1;row>=0;row--)for(int col=cols-1;col>=0;col--)apples[row][col]=(pizza[row].charAt(col)=='A'?1:0)+apples[row+1][col]+apples[row][col+1]-apples[row+1][col+1];
        memo=new int[rows][cols][k];
        for(int[][] a:memo)for(int[] b:a)Arrays.fill(b,-1);
        return dfs(0,0,k-1);
    }
}
