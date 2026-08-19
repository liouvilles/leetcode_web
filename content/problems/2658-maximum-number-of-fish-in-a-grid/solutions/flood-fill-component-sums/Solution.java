class Solution {
    public int findMaxFish(int[][] grid){
        int rows=grid.length,cols=grid[0].length,answer=0;
        int[] directions={
            -1,0,1,0,-1
        };
        for(int startRow=0;startRow<rows;startRow++)for(int startCol=0;startCol<cols;startCol++)if(grid[startRow][startCol]>0){
            Queue<int[]> queue=new ArrayDeque<>();
            int fish=grid[startRow][startCol];
            grid[startRow][startCol]=0;
            queue.add(new int[]{
                startRow,startCol
            });
            while(!queue.isEmpty()){
                int[] cell=queue.poll();
                for(int d=0;d<4;d++){
                    int row=cell[0]+directions[d],col=cell[1]+directions[d+1];
                    if(row>=0&&row<rows&&col>=0&&col<cols&&grid[row][col]>0){
                        fish+=grid[row][col];
                        grid[row][col]=0;
                        queue.add(new int[]{
                            row,col
                        });
                    }
                }
            }
            answer=Math.max(answer,fish);
        }
        return answer;
    }
}
