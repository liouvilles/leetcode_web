class Solution {
    public int minCost(int[][] grid){
        int rows=grid.length,cols=grid[0].length;
        int[][] directions={
            {
                0,1
            },{
                0,-1
            },{
                1,0
            },{
                -1,0
            }
        },dist=new int[rows][cols];
        for(int[] row:dist)Arrays.fill(row,Integer.MAX_VALUE);
        Deque<int[]> deque=new ArrayDeque<>();
        dist[0][0]=0;
        deque.addFirst(new int[]{
            0,0
        });
        while(!deque.isEmpty()){
            int[] cell=deque.removeFirst();
            int row=cell[0],col=cell[1];
            for(int direction=0;direction<4;direction++){
                int nextRow=row+directions[direction][0],nextCol=col+directions[direction][1];
                if(nextRow<0||nextRow>=rows||nextCol<0||nextCol>=cols)continue;
                int weight=grid[row][col]==direction+1?0:1,newDistance=dist[row][col]+weight;
                if(newDistance<dist[nextRow][nextCol]){
                    dist[nextRow][nextCol]=newDistance;
                    if(weight==0)deque.addFirst(new int[]{
                        nextRow,nextCol
                    });
                    else deque.addLast(new int[]{
                        nextRow,nextCol
                    });
                }
            }
        }
        return dist[rows-1][cols-1];
    }
}
