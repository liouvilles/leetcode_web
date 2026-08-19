class Solution {
    public void gameOfLife(int[][] board){
        int m=board.length,n=board[0].length;
        for(int r=0;r<m;r++)for(int c=0;c<n;c++){
            int live=0;
            for(int dr=-1;dr<=1;dr++)for(int dc=-1;dc<=1;dc++){
                int nr=r+dr,nc=c+dc;
                if((dr!=0||dc!=0)&&nr>=0&&nr<m&&nc>=0&&nc<n)live+=board[nr][nc]&1;
            }
            if(live==3||(live==2&&(board[r][c]&1)==1))board[r][c]|=2;
        }
        for(int[] row:board)for(int c=0;c<n;c++)row[c]>>=1;
    }
}
