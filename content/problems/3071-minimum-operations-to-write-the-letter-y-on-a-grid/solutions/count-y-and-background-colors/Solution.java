class Solution {
    public int minimumOperationsToWriteY(int[][] grid){
        int n=grid.length,middle=n/2;
        int[] yCount=new int[3],backgroundCount=new int[3];
        int ySize=0;
        for(int row=0;row<n;row++)for(int column=0;column<n;column++){
            boolean onY=row<=middle?(column==row||column==n-1-row):column==middle;
            if(onY){yCount[grid[row][column]]++;ySize++;}
            else backgroundCount[grid[row][column]]++;
        }
        int answer=n*n;
        for(int y=0;y<3;y++)for(int background=0;background<3;background++)if(y!=background){
            answer=Math.min(answer,ySize-yCount[y]+(n*n-ySize)-backgroundCount[background]);
        }
        return answer;
    }
}
