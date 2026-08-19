class Solution {
    public int[][] transpose(int[][] matrix){
        int rows=matrix.length,columns=matrix[0].length;
        int[][] answer=new int[columns][rows];
        for(int r=0;r<rows;r++)for(int c=0;c<columns;c++)answer[c][r]=matrix[r][c];
        return answer;
    }
}
