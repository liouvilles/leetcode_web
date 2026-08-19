class Solution {
    public int minimumOperations(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        int[] count=new int[10];
        for(int row=0;row<rows;row++)count[grid[row][0]]++;
        int[] previous=new int[10];
        for(int digit=0;digit<10;digit++)previous[digit]=rows-count[digit];
        for(int col=1;col<cols;col++){
            Arrays.fill(count,0);
            for(int row=0;row<rows;row++)count[grid[row][col]]++;
            int[] current=new int[10];
            for(int digit=0;digit<10;digit++){
                int best=Integer.MAX_VALUE;
                for(int previousDigit=0;previousDigit<10;previousDigit++)if(previousDigit!=digit)best=Math.min(best,previous[previousDigit]);
                current[digit]=best+rows-count[digit];
            }
            previous=current;
        }
        return Arrays.stream(previous).min().getAsInt();
    }
}
