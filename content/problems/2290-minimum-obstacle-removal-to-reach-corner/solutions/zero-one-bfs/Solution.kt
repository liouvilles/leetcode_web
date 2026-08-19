class Solution {
    fun minimumObstacles(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val columns=grid[0].size;
        val distance=Array(rows){
            IntArray(columns){
                Int.MAX_VALUE
            }
        };
        val deque=java.util.ArrayDeque<IntArray>();
        distance[0][0]=0;
        deque.addFirst(intArrayOf(0,0));
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        while(deque.isNotEmpty()){
            val cell=deque.removeFirst();
            for(direction in directions){
                val r=cell[0]+direction[0];
                val c=cell[1]+direction[1];
                if(r !in 0 until rows||c !in 0 until columns)continue;
                val next=distance[cell[0]][cell[1]]+grid[r][c];
                if(next<distance[r][c]){
                    distance[r][c]=next;
                    if(grid[r][c]==0)deque.addFirst(intArrayOf(r,c))else deque.addLast(intArrayOf(r,c))
                }
            }
        };
        return distance[rows-1][columns-1]
    }
}
