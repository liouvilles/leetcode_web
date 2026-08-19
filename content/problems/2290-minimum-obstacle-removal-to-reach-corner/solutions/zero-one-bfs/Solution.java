class Solution {
    public int minimumObstacles(int[][] grid){
        int rows=grid.length,columns=grid[0].length;
        int[][] distance=new int[rows][columns];
        for(int[] row:distance)Arrays.fill(row,Integer.MAX_VALUE);
        Deque<int[]> deque=new ArrayDeque<>();
        distance[0][0]=0;
        deque.addFirst(new int[]{
            0,0
        });
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
        while(!deque.isEmpty()){
            int[] cell=deque.pollFirst();
            for(int[] direction:directions){
                int r=cell[0]+direction[0],c=cell[1]+direction[1];
                if(r<0||r>=rows||c<0||c>=columns)continue;
                int next=distance[cell[0]][cell[1]]+grid[r][c];
                if(next<distance[r][c]){
                    distance[r][c]=next;
                    if(grid[r][c]==0)deque.addFirst(new int[]{
                        r,c
                    });
                    else deque.addLast(new int[]{
                        r,c
                    });
                }
            }
        }
        return distance[rows-1][columns-1];
    }
}
