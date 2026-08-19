class Solution {
    fun projectionArea(grid:Array<IntArray>):Int{
        val n=grid.size;
        var top=0;
        val rows=IntArray(n);
        val columns=IntArray(n);
        for(r in 0 until n)for(c in 0 until n){
            if(grid[r][c]>0)top++;
            rows[r]=maxOf(rows[r],grid[r][c]);
            columns[c]=maxOf(columns[c],grid[r][c])
        };
        return top+rows.sum()+columns.sum()
    }
}
