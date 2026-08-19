class Solution {
    fun shortestPath(grid:Array<IntArray>,k:Int):Int{
        val rows=grid.size;
        val columns=grid[0].size;
        if(rows==1&&columns==1)return 0;
        val best=Array(rows){
            IntArray(columns){
                -1
            }
        };
        val queue=java.util.ArrayDeque<IntArray>();
        queue.addLast(intArrayOf(0,0,k,0));
        best[0][0]=k;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        while(queue.isNotEmpty()){
            val state=queue.removeFirst();
            for(d in directions){
                val r=state[0]+d[0];
                val c=state[1]+d[1];
                if(r !in 0 until rows||c !in 0 until columns)continue;
                val remaining=state[2]-grid[r][c];
                if(remaining<0||remaining<=best[r][c])continue;
                if(r==rows-1&&c==columns-1)return state[3]+1;
                best[r][c]=remaining;
                queue.addLast(intArrayOf(r,c,remaining,state[3]+1))
            }
        };
        return -1
    }
}
