class Solution {
    fun findBall(grid:Array<IntArray>):IntArray{
        return IntArray(grid[0].size){
            start->var column=start;
            for(row in grid.indices){
                if(column<0)break;
                val next=column+grid[row][column];
                column=if(next !in grid[0].indices||grid[row][next]!=grid[row][column])-1 else next
            };
            column
        }
    }
}
