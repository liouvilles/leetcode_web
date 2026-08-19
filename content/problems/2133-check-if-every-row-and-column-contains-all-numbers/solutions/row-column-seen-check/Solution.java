class Solution {
    public boolean checkValid(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            boolean[] row=new boolean[n+1],column=new boolean[n+1];
            for(int j=0;j<n;j++){
                int a=matrix[i][j],b=matrix[j][i];
                if(a<1||a>n||row[a]||b<1||b>n||column[b])return false;
                row[a]=true;
                column[b]=true;
            }
        }
        return true;
    }
}
