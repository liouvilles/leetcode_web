class Solution {
    public int maxSideLength(int[][] mat,int threshold){
        int rows=mat.length,columns=mat[0].length;
        int[][] prefix=new int[rows+1][columns+1];
        for(int r=0;r<rows;r++)for(int c=0;c<columns;c++)prefix[r+1][c+1]=mat[r][c]+prefix[r][c+1]+prefix[r+1][c]-prefix[r][c];
        int left=0,right=Math.min(rows,columns);
        while(left<right){
            int middle=(left+right+1)/2;
            if(feasible(prefix,rows,columns,middle,threshold))left=middle;
            else right=middle-1;
        }
        return left;
    }
    private boolean feasible(int[][] prefix,int rows,int columns,int side,int threshold){
        for(int r=side;r<=rows;r++)for(int c=side;c<=columns;c++)if(prefix[r][c]-prefix[r-side][c]-prefix[r][c-side]+prefix[r-side][c-side]<=threshold)return true;
        return false;
    }
}
