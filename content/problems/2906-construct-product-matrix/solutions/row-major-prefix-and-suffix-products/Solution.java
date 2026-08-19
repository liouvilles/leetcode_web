class Solution {
    public int[][] constructProductMatrix(int[][] grid){
        final int MOD=12345;
        int rows=grid.length,columns=grid[0].length;
        int[][] answer=new int[rows][columns];
        long prefix=1;
        for(int row=0;row<rows;row++)for(int column=0;column<columns;column++){
            answer[row][column]=(int)prefix;
            prefix=prefix*(grid[row][column]%MOD)%MOD;
        }
        long suffix=1;
        for(int row=rows-1;row>=0;row--)for(int column=columns-1;column>=0;column--){
            answer[row][column]=(int)(answer[row][column]*suffix%MOD);
            suffix=suffix*(grid[row][column]%MOD)%MOD;
        }
        return answer;
    }
}
