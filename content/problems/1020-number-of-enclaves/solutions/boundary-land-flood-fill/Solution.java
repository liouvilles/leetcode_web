class Solution {
    public int numEnclaves(int[][] grid){
        int rows=grid.length,columns=grid[0].length;
        for(int r=0;r<rows;r++){
            flood(grid,r,0);
            flood(grid,r,columns-1);
        }
        for(int c=0;c<columns;c++){
            flood(grid,0,c);
            flood(grid,rows-1,c);
        }
        int answer=0;
        for(int[] row:grid)for(int cell:row)answer+=cell;
        return answer;
    }
    private void flood(int[][] grid,int r,int c){
        if(r<0||r==grid.length||c<0||c==grid[0].length||grid[r][c]!=1)return;
        grid[r][c]=0;
        flood(grid,r+1,c);
        flood(grid,r-1,c);
        flood(grid,r,c+1);
        flood(grid,r,c-1);
    }
}
