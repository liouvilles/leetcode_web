class Solution {
    private lateinit var grid:Array<IntArray>;
    private var rows=0;
    private var columns=0;
    fun closedIsland(grid:Array<IntArray>):Int{
        this.grid=grid;
        rows=grid.size;
        columns=grid[0].size;
        for(r in 0 until rows){
            flood(r,0);
            flood(r,columns-1)
        };
        for(c in 0 until columns){
            flood(0,c);
            flood(rows-1,c)
        };
        var answer=0;
        for(r in 1 until rows-1)for(c in 1 until columns-1)if(grid[r][c]==0){
            answer++;
            flood(r,c)
        };
        return answer
    };
    private fun flood(r:Int,c:Int){
        if(r !in 0 until rows||c !in 0 until columns||grid[r][c]!=0)return;
        grid[r][c]=1;
        flood(r+1,c);
        flood(r-1,c);
        flood(r,c+1);
        flood(r,c-1)
    }
}
