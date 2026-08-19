class Solution {
    public int nearestExit(char[][] maze,int[] entrance){
        int rows=maze.length,cols=maze[0].length;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{
            entrance[0],entrance[1],0
        });
        maze[entrance[0]][entrance[1]]='+';
        int[][] directions={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        };
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int row=current[0],col=current[1],distance=current[2];
            if(distance>0&&(row==0||row==rows-1||col==0||col==cols-1))return distance;
            for(int[] direction:directions){
                int nextRow=row+direction[0],nextCol=col+direction[1];
                if(nextRow>=0&&nextRow<rows&&nextCol>=0&&nextCol<cols&&maze[nextRow][nextCol]=='.'){
                    maze[nextRow][nextCol]='+';
                    queue.offer(new int[]{
                        nextRow,nextCol,distance+1
                    });
                }
            }
        }
        return -1;
    }
}
