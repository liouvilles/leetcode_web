class Solution {
    fun maxDistance(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val columns=grid[0].size;
        val queue=java.util.ArrayDeque<IntArray>();
        for(r in 0 until rows)for(c in 0 until columns)if(grid[r][c]==1)queue.addLast(intArrayOf(r,c));
        if(queue.isEmpty()||queue.size==rows*columns)return -1;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        var distance=-1;
        while(queue.isNotEmpty()){
            var size=queue.size;
            distance++;
            while(size-->0){
                val cell=queue.removeFirst();
                for(direction in directions){
                    val r=cell[0]+direction[0];
                    val c=cell[1]+direction[1];
                    if(r in 0 until rows&&c in 0 until columns&&grid[r][c]==0){
                        grid[r][c]=1;
                        queue.addLast(intArrayOf(r,c))
                    }
                }
            }
        };
        return distance
    }
}
