class Solution {
    public int largestMagicSquare(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        int[][] rowPrefix=new int[rows][cols+1],colPrefix=new int[rows+1][cols];
        for(int r=0;r<rows;r++)for(int c=0;c<cols;c++){
            rowPrefix[r][c+1]=rowPrefix[r][c]+grid[r][c];
            colPrefix[r+1][c]=colPrefix[r][c]+grid[r][c];
        }
        for(int size=Math.min(rows,cols);size>=1;size--)for(int top=0;top+size<=rows;top++)for(int left=0;left+size<=cols;left++){
            int target=rowPrefix[top][left+size]-rowPrefix[top][left];
            boolean valid=true;
            for(int offset=0;offset<size&&valid;offset++)valid=rowPrefix[top+offset][left+size]-rowPrefix[top+offset][left]==target&&colPrefix[top+size][left+offset]-colPrefix[top][left+offset]==target;
            int first=0,second=0;
            for(int offset=0;offset<size;offset++){
                first+=grid[top+offset][left+offset];
                second+=grid[top+offset][left+size-1-offset];
            }
            if(valid&&first==target&&second==target)return size;
        }
        return 1;
    }
}
