class Solution {
    fun largestLocal(grid:Array<IntArray>):Array<IntArray>{
        val n=grid.size;
        return Array(n-2){
            row->IntArray(n-2){
                column->var maximum=0;
                for(r in row..row+2)for(c in column..column+2)maximum=maxOf(maximum,grid[r][c]);
                maximum
            }
        }
    }
}
