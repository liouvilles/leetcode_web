class Solution {
    public int maximumRows(int[][] matrix,int numSelect){
        int rows=matrix.length,columns=matrix[0].length;
        int[] masks=new int[rows];
        for(int r=0;r<rows;r++)for(int c=0;c<columns;c++)if(matrix[r][c]==1)masks[r]|=1<<c;
        int answer=0;
        for(int selected=0;selected<(1<<columns);selected++)if(Integer.bitCount(selected)==numSelect){
            int covered=0;
            for(int mask:masks)if((mask&selected)==mask)covered++;
            answer=Math.max(answer,covered);
        }
        return answer;
    }
}
