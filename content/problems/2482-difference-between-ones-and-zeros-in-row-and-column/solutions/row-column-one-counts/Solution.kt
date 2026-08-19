class Solution {
    fun onesMinusZeros(grid:Array<IntArray>):Array<IntArray>{
        val rows=grid.size;
        val cols=grid[0].size;
        val rowOnes=IntArray(rows);
        val colOnes=IntArray(cols);
        for(row in 0 until rows)for(col in 0 until cols)if(grid[row][col]==1){
            rowOnes[row]++;
            colOnes[col]++
        };
        return Array(rows){
            row->IntArray(cols){
                col->2*(rowOnes[row]+colOnes[col])-rows-cols
            }
        }
    }
}
