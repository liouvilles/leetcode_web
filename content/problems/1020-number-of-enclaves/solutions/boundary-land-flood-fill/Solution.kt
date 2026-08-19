class Solution {
    fun numEnclaves(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val columns=grid[0].size;
        fun flood(r:Int,c:Int){
            if(r !in 0 until rows||c !in 0 until columns||grid[r][c]!=1)return;
            grid[r][c]=0;
            flood(r+1,c);
            flood(r-1,c);
            flood(r,c+1);
            flood(r,c-1)
        };
        for(r in 0 until rows){
            flood(r,0);
            flood(r,columns-1)
        };
        for(c in 0 until columns){
            flood(0,c);
            flood(rows-1,c)
        };
        return grid.sumOf{
            it.sum()
        }
    }
}
