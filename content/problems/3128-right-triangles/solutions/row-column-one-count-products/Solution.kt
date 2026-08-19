class Solution {
    fun numberOfRightTriangles(grid:Array<IntArray>):Long{
        val rows=grid.size;
        val cols=grid[0].size;
        val rowOnes=IntArray(rows);
        val colOnes=IntArray(cols);
        for(row in 0 until rows)for(col in 0 until cols)if(grid[row][col]==1){
            rowOnes[row]++;
            colOnes[col]++
        };
        var answer=0L;
        for(row in 0 until rows)for(col in 0 until cols)if(grid[row][col]==1)answer+=(rowOnes[row]-1).toLong()*(colOnes[col]-1);
        return answer
    }
}
