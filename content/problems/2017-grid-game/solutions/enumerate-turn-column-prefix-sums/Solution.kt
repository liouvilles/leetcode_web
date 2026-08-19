class Solution {
    fun gridGame(grid:Array<IntArray>):Long{
        var top=grid[0].sumOf{
            it.toLong()
        };
        var bottom=0L;
        var answer=Long.MAX_VALUE;
        for(col in grid[0].indices){
            top-=grid[0][col];
            answer=minOf(answer,maxOf(top,bottom));
            bottom+=grid[1][col]
        };
        return answer
    }
}
