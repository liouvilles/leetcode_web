class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid){
        int n=grid.length;
        int[] rowMax=new int[n],columnMax=new int[n];
        for(int r=0;r<n;r++)for(int c=0;c<n;c++){
            rowMax[r]=Math.max(rowMax[r],grid[r][c]);
            columnMax[c]=Math.max(columnMax[c],grid[r][c]);
        }
        int answer=0;
        for(int r=0;r<n;r++)for(int c=0;c<n;c++)answer+=Math.min(rowMax[r],columnMax[c])-grid[r][c];
        return answer;
    }
}
