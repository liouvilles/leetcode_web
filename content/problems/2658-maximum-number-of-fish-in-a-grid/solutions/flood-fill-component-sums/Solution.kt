class Solution {
    fun findMaxFish(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val cols=grid[0].size;
        val directions=intArrayOf(-1,0,1,0,-1);
        var answer=0;
        for(startRow in 0 until rows)for(startCol in 0 until cols)if(grid[startRow][startCol]>0){
            val queue=java.util.ArrayDeque<IntArray>();
            var fish=grid[startRow][startCol];
            grid[startRow][startCol]=0;
            queue.add(intArrayOf(startRow,startCol));
            while(queue.isNotEmpty()){
                val cell=queue.removeFirst();
                for(d in 0 until 4){
                    val row=cell[0]+directions[d];
                    val col=cell[1]+directions[d+1];
                    if(row in 0 until rows&&col in 0 until cols&&grid[row][col]>0){
                        fish+=grid[row][col];
                        grid[row][col]=0;
                        queue.add(intArrayOf(row,col))
                    }
                }
            };
            answer=maxOf(answer,fish)
        };
        return answer
    }
}
