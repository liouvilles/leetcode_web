class Solution {
    public int[] findBall(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        int[] answer=new int[cols];
        for(int start=0;start<cols;start++){
            int column=start;
            for(int row=0;row<rows&&column>=0;row++){
                int next=column+grid[row][column];
                if(next<0||next>=cols||grid[row][next]!=grid[row][column])column=-1;
                else column=next;
            }
            answer[start]=column;
        }
        return answer;
    }
}
