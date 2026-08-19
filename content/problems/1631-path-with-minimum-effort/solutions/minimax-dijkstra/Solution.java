class Solution {
    public int minimumEffortPath(int[][] heights){
        int rows=heights.length,cols=heights[0].length;
        int[][] effort=new int[rows][cols];
        for(int[] row:effort)Arrays.fill(row,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(state->state[0]));
        effort[0][0]=0;
        queue.offer(new int[]{
            0,0,0
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
        while(!queue.isEmpty()){
            int[] state=queue.poll();
            int cost=state[0],row=state[1],col=state[2];
            if(cost!=effort[row][col])continue;
            if(row==rows-1&&col==cols-1)return cost;
            for(int[] direction:directions){
                int nextRow=row+direction[0],nextCol=col+direction[1];
                if(nextRow<0||nextRow>=rows||nextCol<0||nextCol>=cols)continue;
                int candidate=Math.max(cost,Math.abs(heights[row][col]-heights[nextRow][nextCol]));
                if(candidate<effort[nextRow][nextCol]){
                    effort[nextRow][nextCol]=candidate;
                    queue.offer(new int[]{
                        candidate,nextRow,nextCol
                    });
                }
            }
        }
        return 0;
    }
}
