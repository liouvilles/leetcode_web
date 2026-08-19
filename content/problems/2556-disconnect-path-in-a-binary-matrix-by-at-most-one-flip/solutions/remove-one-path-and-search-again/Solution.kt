class Solution {
    private lateinit var grid:Array<IntArray>;
    private var rows=0;
    private var cols=0;
    private fun path(row:Int,col:Int):Boolean{
        if(row>=rows||col>=cols||grid[row][col]==0)return false;
        if(row==rows-1&&col==cols-1)return true;
        grid[row][col]=0;
        return path(row+1,col)||path(row,col+1)
    }
    fun isPossibleToCutPath(grid:Array<IntArray>):Boolean{
        this.grid=grid;
        rows=grid.size;
        cols=grid[0].size;
        if(!path(0,0))return true;
        grid[0][0]=1;
        grid[rows-1][cols-1]=1;
        return !path(0,0)
    }
}
