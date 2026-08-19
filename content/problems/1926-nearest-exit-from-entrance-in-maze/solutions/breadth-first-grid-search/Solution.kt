class Solution {
    fun nearestExit(maze:Array<CharArray>,entrance:IntArray):Int{
        val rows=maze.size;
        val cols=maze[0].size;
        val queue=java.util.ArrayDeque<IntArray>();
        queue.add(intArrayOf(entrance[0],entrance[1],0));
        maze[entrance[0]][entrance[1]]='+';
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        while(queue.isNotEmpty()){
            val current=queue.removeFirst();
            val row=current[0];
            val col=current[1];
            val distance=current[2];
            if(distance>0&&(row==0||row==rows-1||col==0||col==cols-1))return distance;
            for(direction in directions){
                val nextRow=row+direction[0];
                val nextCol=col+direction[1];
                if(nextRow in 0 until rows&&nextCol in 0 until cols&&maze[nextRow][nextCol]=='.'){
                    maze[nextRow][nextCol]='+';
                    queue.add(intArrayOf(nextRow,nextCol,distance+1))
                }
            }
        };
        return -1
    }
}
