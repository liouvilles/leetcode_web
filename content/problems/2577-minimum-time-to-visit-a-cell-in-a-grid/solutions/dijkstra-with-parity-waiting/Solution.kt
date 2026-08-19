class Solution {
    fun minimumTime(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val cols=grid[0].size;
        if(rows==1&&cols==1)return 0;
        val canLeave=rows>1&&grid[1][0]<=1||cols>1&&grid[0][1]<=1;
        if(!canLeave)return -1;
        val distance=Array(rows){
            IntArray(cols){
                Int.MAX_VALUE
            }
        };
        val queue=java.util.PriorityQueue<IntArray>(compareBy<IntArray>{
            it[0]
        });
        distance[0][0]=0;
        queue.offer(intArrayOf(0,0,0));
        val directions=intArrayOf(-1,0,1,0,-1);
        while(queue.isNotEmpty()){
            val current=queue.poll();
            val time=current[0];
            val row=current[1];
            val col=current[2];
            if(time!=distance[row][col])continue;
            if(row==rows-1&&col==cols-1)return time;
            for(d in 0 until 4){
                val nextRow=row+directions[d];
                val nextCol=col+directions[d+1];
                if(nextRow !in 0 until rows||nextCol !in 0 until cols)continue;
                var nextTime=time+1;
                val required=grid[nextRow][nextCol];
                if(nextTime<required)nextTime=required+((required-nextTime) and 1);
                if(nextTime<distance[nextRow][nextCol]){
                    distance[nextRow][nextCol]=nextTime;
                    queue.offer(intArrayOf(nextTime,nextRow,nextCol))
                }
            }
        };
        return -1
    }
}
