class Solution {
    fun highestPeak(isWater:Array<IntArray>):Array<IntArray>{
        val rows=isWater.size;
        val cols=isWater[0].size;
        val height=Array(rows){
            IntArray(cols)
        };
        val queue=java.util.ArrayDeque<IntArray>();
        for(row in 0 until rows)for(col in 0 until cols)if(isWater[row][col]==1)queue.addLast(intArrayOf(row,col)) else height[row][col]=-1;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        while(queue.isNotEmpty()){
            val cell=queue.removeFirst();
            for(direction in directions){
                val row=cell[0]+direction[0];
                val col=cell[1]+direction[1];
                if(row in 0 until rows&&col in 0 until cols&&height[row][col]<0){
                    height[row][col]=height[cell[0]][cell[1]]+1;
                    queue.addLast(intArrayOf(row,col))
                }
            }
        };
        return height
    }
}
