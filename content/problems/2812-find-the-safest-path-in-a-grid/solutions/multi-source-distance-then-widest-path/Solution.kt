class Solution {
    fun maximumSafenessFactor(grid:List<List<Int>>):Int{
        val n=grid.size;
        val distance=Array(n){
            IntArray(n){
                -1
            }
        };
        val queue=java.util.ArrayDeque<IntArray>();
        for(row in 0 until n)for(col in 0 until n)if(grid[row][col]==1){
            distance[row][col]=0;
            queue.addLast(intArrayOf(row,col))
        };
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        while(!queue.isEmpty()){
            val cell=queue.pollFirst();
            for(direction in directions){
                val row=cell[0]+direction[0];
                val col=cell[1]+direction[1];
                if(row in 0 until n&&col in 0 until n&&distance[row][col]==-1){
                    distance[row][col]=distance[cell[0]][cell[1]]+1;
                    queue.addLast(intArrayOf(row,col))
                }
            }
        };
        val best=Array(n){
            IntArray(n){
                -1
            }
        };
        val heap=java.util.PriorityQueue<IntArray>(Comparator{
            a,b->b[0].compareTo(a[0])
        });
        best[0][0]=distance[0][0];
        heap.add(intArrayOf(best[0][0],0,0));
        while(heap.isNotEmpty()){
            val state=heap.poll();
            val safety=state[0];
            val row=state[1];
            val col=state[2];
            if(safety<best[row][col])continue;
            if(row==n-1&&col==n-1)return safety;
            for(direction in directions){
                val nextRow=row+direction[0];
                val nextCol=col+direction[1];
                if(nextRow in 0 until n&&nextCol in 0 until n){
                    val candidate=minOf(safety,distance[nextRow][nextCol]);
                    if(candidate>best[nextRow][nextCol]){
                        best[nextRow][nextCol]=candidate;
                        heap.add(intArrayOf(candidate,nextRow,nextCol))
                    }
                }
            }
        };
        return 0
    }
}
