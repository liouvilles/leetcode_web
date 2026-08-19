class Solution {
    public int minimumTime(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        if(rows==1&&cols==1)return 0;
        boolean canLeave=rows>1&&grid[1][0]<=1||cols>1&&grid[0][1]<=1;
        if(!canLeave)return -1;
        int[][] distance=new int[rows][cols];
        for(int[] row:distance)Arrays.fill(row,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        distance[0][0]=0;
        queue.offer(new int[]{
            0,0,0
        });
        int[] directions={
            -1,0,1,0,-1
        };
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int time=current[0],row=current[1],col=current[2];
            if(time!=distance[row][col])continue;
            if(row==rows-1&&col==cols-1)return time;
            for(int d=0;d<4;d++){
                int nextRow=row+directions[d],nextCol=col+directions[d+1];
                if(nextRow<0||nextRow>=rows||nextCol<0||nextCol>=cols)continue;
                int nextTime=time+1,required=grid[nextRow][nextCol];
                if(nextTime<required)nextTime=required+((required-nextTime)&1);
                if(nextTime<distance[nextRow][nextCol]){
                    distance[nextRow][nextCol]=nextTime;
                    queue.offer(new int[]{
                        nextTime,nextRow,nextCol
                    });
                }
            }
        }
        return -1;
    }
}
