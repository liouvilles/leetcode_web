class Solution {
    public int maxDistance(int[][] grid){
        int rows=grid.length,columns=grid[0].length;
        Queue<int[]> queue=new ArrayDeque<>();
        for(int r=0;r<rows;r++)for(int c=0;c<columns;c++)if(grid[r][c]==1)queue.offer(new int[]{
            r,c
        });
        if(queue.isEmpty()||queue.size()==rows*columns)return -1;
        int distance=-1;
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
            int size=queue.size();
            distance++;
            while(size-->0){
                int[] cell=queue.poll();
                for(int[] direction:directions){
                    int r=cell[0]+direction[0],c=cell[1]+direction[1];
                    if(r>=0&&r<rows&&c>=0&&c<columns&&grid[r][c]==0){
                        grid[r][c]=1;
                        queue.offer(new int[]{
                            r,c
                        });
                    }
                }
            }
        }
        return distance;
    }
}
