class Solution {
    fun matrixScore(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val columns=grid[0].size;
        var answer=0;
        for(c in 0 until columns){
            var ones=0;
            for(r in 0 until rows)if((grid[r][c] xor grid[r][0])==0)ones++;
            ones=maxOf(ones,rows-ones);
            answer+=ones*(1 shl(columns-1-c))
        };
        return answer
    }
}
