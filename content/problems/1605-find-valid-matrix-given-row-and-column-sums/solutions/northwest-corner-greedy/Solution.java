class Solution {
    public int[][] restoreMatrix(int[] rowSum,int[] colSum){
        int[][] matrix=new int[rowSum.length][colSum.length];
        int row=0,col=0;
        while(row<rowSum.length&&col<colSum.length){
            int value=Math.min(rowSum[row],colSum[col]);
            matrix[row][col]=value;
            rowSum[row]-=value;
            colSum[col]-=value;
            if(rowSum[row]==0)row++;
            if(colSum[col]==0)col++;
        }
        return matrix;
    }
}
