class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        int[][] answer=new int[rows][cols];
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++){
            Set<Integer> topLeft=new HashSet<>(),bottomRight=new HashSet<>();
            for(int r=row-1,c=col-1;r>=0&&c>=0;r--,c--)topLeft.add(grid[r][c]);
            for(int r=row+1,c=col+1;r<rows&&c<cols;r++,c++)bottomRight.add(grid[r][c]);
            answer[row][col]=Math.abs(topLeft.size()-bottomRight.size());
        }
        return answer;
    }
}
