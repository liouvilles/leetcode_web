class Solution {
    public int numSpecial(int[][] mat){
        int[] rows=new int[mat.length],cols=new int[mat[0].length];
        for(int row=0;row<mat.length;row++)for(int col=0;col<mat[0].length;col++)if(mat[row][col]==1){
            rows[row]++;
            cols[col]++;
        }
        int answer=0;
        for(int row=0;row<mat.length;row++)for(int col=0;col<mat[0].length;col++)if(mat[row][col]==1&&rows[row]==1&&cols[col]==1)answer++;
        return answer;
    }
}
