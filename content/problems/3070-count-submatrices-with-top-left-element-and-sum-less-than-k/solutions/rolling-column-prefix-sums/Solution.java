class Solution {
    public int countSubmatrices(int[][] grid,int k){
        long[] columnSums=new long[grid[0].length];
        int answer=0;
        for(int[] row:grid){
            long prefix=0;
            for(int column=0;column<row.length;column++){
                columnSums[column]+=row[column];
                prefix+=columnSums[column];
                if(prefix<=k)answer++;
            }
        }
        return answer;
    }
}
