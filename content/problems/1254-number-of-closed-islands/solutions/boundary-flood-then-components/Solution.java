class Solution {
    private int[][] grid;
    private int rows,columns;
    public int closedIsland(int[][] grid){
        this.grid=grid;
        rows=grid.length;
        columns=grid[0].length;
        for(int r=0;r<rows;r++){
            flood(r,0);
            flood(r,columns-1);
        }
        for(int c=0;c<columns;c++){
            flood(0,c);
            flood(rows-1,c);
        }
        int answer=0;
        for(int r=1;r<rows-1;r++)for(int c=1;c<columns-1;c++)if(grid[r][c]==0){
            answer++;
            flood(r,c);
        }
        return answer;
    }
    private void flood(int r,int c){
        if(r<0||r>=rows||c<0||c>=columns||grid[r][c]!=0)return;
        grid[r][c]=1;
        flood(r+1,c);
        flood(r-1,c);
        flood(r,c+1);
        flood(r,c-1);
    }
}
