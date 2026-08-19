class Solution {
    fun maxPoints(grid:Array<IntArray>,queries:IntArray):IntArray{
        val rows=grid.size;
        val cols=grid[0].size;
        val order=queries.indices.sortedBy{
            queries[it]
        };
        val heap=java.util.PriorityQueue<IntArray>(compareBy{
            it[0]
        });
        val visited=Array(rows){
            BooleanArray(cols)
        };
        heap.offer(intArrayOf(grid[0][0],0,0));
        visited[0][0]=true;
        val answer=IntArray(queries.size);
        var count=0;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        for(index in order){
            while(heap.isNotEmpty()&&heap.peek()[0]<queries[index]){
                val cell=heap.poll();
                count++;
                for(direction in directions){
                    val row=cell[1]+direction[0];
                    val col=cell[2]+direction[1];
                    if(row in 0 until rows&&col in 0 until cols&&!visited[row][col]){
                        visited[row][col]=true;
                        heap.offer(intArrayOf(grid[row][col],row,col))
                    }
                }
            };
            answer[index]=count
        };
        return answer
    }
}
