class Solution {
    public int[][] modifiedMatrix(int[][] matrix){
        for(int column=0;column<matrix[0].length;column++){
            int maximum=0;
            for(int[] row:matrix)maximum=Math.max(maximum,row[column]);
            for(int[] row:matrix)if(row[column]==-1)row[column]=maximum;
        }
        return matrix;
    }
}
