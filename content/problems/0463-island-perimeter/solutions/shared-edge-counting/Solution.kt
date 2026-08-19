class Solution {
    fun islandPerimeter(grid:Array<IntArray>):Int{
        var perimeter=0;
        for(r in grid.indices)for(c in grid[0].indices)if(grid[r][c]==1){
            perimeter+=4;
            if(r>0&&grid[r-1][c]==1)perimeter-=2;
            if(c>0&&grid[r][c-1]==1)perimeter-=2
        };
        return perimeter
    }
}
