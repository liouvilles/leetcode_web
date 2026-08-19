class Solution {
    private int maximumRow(int[][] mat,int col){
        int row=0;
        for(int i=1;i<mat.length;i++)if(mat[i][col]>mat[row][col])row=i;
        return row;
    }
    public int[] findPeakGrid(int[][] mat){
        int left=0,right=mat[0].length-1;
        while(left<right){
            int middle=(left+right)/2,row=maximumRow(mat,middle);
            if(mat[row][middle]<mat[row][middle+1])left=middle+1;
            else right=middle;
        }
        return new int[]{
            maximumRow(mat,left),left
        };
    }
}
