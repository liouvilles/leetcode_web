class Solution {
    fun shortestBridge(grid:Array<IntArray>):Int{
        val n=grid.size;
        val flood=java.util.ArrayDeque<IntArray>();
        val frontier=java.util.ArrayDeque<IntArray>();
        loop@for(r in 0 until n)for(c in 0 until n)if(grid[r][c]==1){
            flood.addLast(intArrayOf(r,c));
            grid[r][c]=2;
            break@loop
        };
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        while(flood.isNotEmpty()){
            val cell=flood.removeFirst();
            frontier.addLast(cell);
            for(d in directions){
                val r=cell[0]+d[0];
                val c=cell[1]+d[1];
                if(r in 0 until n&&c in 0 until n&&grid[r][c]==1){
                    grid[r][c]=2;
                    flood.addLast(intArrayOf(r,c))
                }
            }
        };
        var distance=0;
        while(frontier.isNotEmpty()){
            repeat(frontier.size){
                val cell=frontier.removeFirst();
                for(d in directions){
                    val r=cell[0]+d[0];
                    val c=cell[1]+d[1];
                    if(r !in 0 until n||c !in 0 until n||grid[r][c]==2)continue;
                    if(grid[r][c]==1)return distance;
                    grid[r][c]=2;
                    frontier.addLast(intArrayOf(r,c))
                }
            };
            distance++
        };
        return -1
    }
}
