class Solution {
    public int[][] updateMatrix(int[][] mat){
        int rows=mat.length,cols=mat[0].length;
        int[][] distance=new int[rows][cols];
        for(int[] row:distance)Arrays.fill(row,-1);
        Queue<int[]> queue=new ArrayDeque<>();
        for(int r=0;r<rows;r++)for(int c=0;c<cols;c++)if(mat[r][c]==0){
            distance[r][c]=0;
            queue.offer(new int[]{
                r,c
            });
        }
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
            int[] cell=queue.poll();
            for(int[] d:directions){
                int r=cell[0]+d[0],c=cell[1]+d[1];
                if(r>=0&&r<rows&&c>=0&&c<cols&&distance[r][c]==-1){
                    distance[r][c]=distance[cell[0]][cell[1]]+1;
                    queue.offer(new int[]{
                        r,c
                    });
                }
            }
        }
        return distance;
    }
}
