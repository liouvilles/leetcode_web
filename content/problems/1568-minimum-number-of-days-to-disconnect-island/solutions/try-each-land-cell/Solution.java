class Solution {
    private int[][] grid;
    private int rows,cols;
    private void dfs(int row,int col,boolean[][] seen){
        if(row<0||row>=rows||col<0||col>=cols||grid[row][col]==0||seen[row][col])return;
        seen[row][col]=true;
        dfs(row+1,col,seen);
        dfs(row-1,col,seen);
        dfs(row,col+1,seen);
        dfs(row,col-1,seen);
    }
    private int islands(){
        boolean[][] seen=new boolean[rows][cols];
        int count=0;
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)if(grid[row][col]==1&&!seen[row][col]){
            count++;
            dfs(row,col,seen);
        }
        return count;
    }
    public int minDays(int[][] grid){
        this.grid=grid;
        rows=grid.length;
        cols=grid[0].length;
        if(islands()!=1)return 0;
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)if(grid[row][col]==1){
            grid[row][col]=0;
            int count=islands();
            grid[row][col]=1;
            if(count!=1)return 1;
        }
        return 2;
    }
}
