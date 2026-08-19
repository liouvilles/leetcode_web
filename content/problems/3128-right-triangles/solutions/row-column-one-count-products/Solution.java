class Solution {
    public long numberOfRightTriangles(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        int[] rowOnes=new int[rows],colOnes=new int[cols];
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)if(grid[row][col]==1){
            rowOnes[row]++;
            colOnes[col]++;
        }
        long answer=0;
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)if(grid[row][col]==1)answer+=(long)(rowOnes[row]-1)*(colOnes[col]-1);
        return answer;
    }
}
