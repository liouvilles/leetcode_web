class Solution {
    public int kthLargestValue(int[][] matrix,int k){
        int rows=matrix.length,cols=matrix[0].length;
        int[][] prefix=new int[rows+1][cols+1];
        int[] values=new int[rows*cols];
        int index=0;
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++){
            prefix[row+1][col+1]=matrix[row][col]^prefix[row][col+1]^prefix[row+1][col]^prefix[row][col];
            values[index++]=prefix[row+1][col+1];
        }
        Arrays.sort(values);
        return values[values.length-k];
    }
}
