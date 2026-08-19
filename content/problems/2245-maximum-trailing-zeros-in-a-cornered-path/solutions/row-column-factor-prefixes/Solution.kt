class Solution {
    private fun factor(valueValue:Int,divisor:Int):Int{
        var value=valueValue;
        var count=0;
        while(value%divisor==0){
            count++;
            value/=divisor
        };
        return count
    };
    fun maxTrailingZeros(grid:Array<IntArray>):Int{
        val rows=grid.size;
        val columns=grid[0].size;
        val two=Array(rows){
            IntArray(columns)
        };
        val five=Array(rows){
            IntArray(columns)
        };
        val rowTwo=Array(rows){
            IntArray(columns+1)
        };
        val rowFive=Array(rows){
            IntArray(columns+1)
        };
        val columnTwo=Array(rows+1){
            IntArray(columns)
        };
        val columnFive=Array(rows+1){
            IntArray(columns)
        };
        for(r in 0 until rows)for(c in 0 until columns){
            two[r][c]=factor(grid[r][c],2);
            five[r][c]=factor(grid[r][c],5);
            rowTwo[r][c+1]=rowTwo[r][c]+two[r][c];
            rowFive[r][c+1]=rowFive[r][c]+five[r][c];
            columnTwo[r+1][c]=columnTwo[r][c]+two[r][c];
            columnFive[r+1][c]=columnFive[r][c]+five[r][c]
        };
        var answer=0;
        for(r in 0 until rows)for(c in 0 until columns){
            val ht=intArrayOf(rowTwo[r][c+1],rowTwo[r][columns]-rowTwo[r][c]);
            val hf=intArrayOf(rowFive[r][c+1],rowFive[r][columns]-rowFive[r][c]);
            val vt=intArrayOf(columnTwo[r+1][c],columnTwo[rows][c]-columnTwo[r][c]);
            val vf=intArrayOf(columnFive[r+1][c],columnFive[rows][c]-columnFive[r][c]);
            for(h in 0..1)for(v in 0..1)answer=maxOf(answer,minOf(ht[h]+vt[v]-two[r][c],hf[h]+vf[v]-five[r][c]))
        };
        return answer
    }
}
