class Solution {
    public int[][] matrixBlockSum(int[][] mat,int k){
        int rows=mat.length,columns=mat[0].length;
        int[][] prefix=new int[rows+1][columns+1],answer=new int[rows][columns];
        for(int r=0;r<rows;r++)for(int c=0;c<columns;c++)prefix[r+1][c+1]=mat[r][c]+prefix[r][c+1]+prefix[r+1][c]-prefix[r][c];
        for(int r=0;r<rows;r++)for(int c=0;c<columns;c++){
            int top=Math.max(0,r-k),bottom=Math.min(rows-1,r+k),left=Math.max(0,c-k),right=Math.min(columns-1,c+k);
            answer[r][c]=prefix[bottom+1][right+1]-prefix[top][right+1]-prefix[bottom+1][left]+prefix[top][left];
        }
        return answer;
    }
}
