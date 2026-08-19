class Solution {
    fun minimumOperations(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val cols=grid[0].size;
        val count=IntArray(10);
        for(row in 0 until rows)count[grid[row][0]]++;
        var previous=IntArray(10){
            digit->rows-count[digit]
        };
        for(col in 1 until cols){
            count.fill(0);
            for(row in 0 until rows)count[grid[row][col]]++;
            val current=IntArray(10);
            for(digit in 0 until 10){
                var best=Int.MAX_VALUE;
                for(previousDigit in 0 until 10)if(previousDigit!=digit)best=minOf(best,previous[previousDigit]);
                current[digit]=best+rows-count[digit]
            };
            previous=current
        };
        return previous.min()
    }
}
