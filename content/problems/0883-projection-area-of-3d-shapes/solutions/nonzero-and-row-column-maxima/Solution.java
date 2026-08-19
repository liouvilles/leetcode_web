class Solution {
    public int projectionArea(int[][] grid){
        int n=grid.length,top=0;
        int[] rows=new int[n],columns=new int[n];
        for(int r=0;r<n;r++)for(int c=0;c<n;c++){
            if(grid[r][c]>0)top++;
            rows[r]=Math.max(rows[r],grid[r][c]);
            columns[c]=Math.max(columns[c],grid[r][c]);
        }
        return top+Arrays.stream(rows).sum()+Arrays.stream(columns).sum();
    }
}
