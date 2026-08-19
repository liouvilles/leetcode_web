class Solution {
    public boolean canMakeSquare(char[][] grid){
        for(int row=0;row<2;row++)for(int col=0;col<2;col++){
            int black=0;
            for(int dr=0;dr<2;dr++)for(int dc=0;dc<2;dc++)if(grid[row+dr][col+dc]=='B')black++;
            if(black!=2)return true;
        }
        return false;
    }
}
