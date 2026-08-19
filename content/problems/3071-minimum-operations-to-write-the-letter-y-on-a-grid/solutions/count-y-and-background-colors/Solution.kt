class Solution {
    fun minimumOperationsToWriteY(grid:Array<IntArray>):Int{
        val n=grid.size
        val middle=n/2
        val yCount=IntArray(3)
        val backgroundCount=IntArray(3)
        var ySize=0
        for(row in 0 until n)for(column in 0 until n){
            val onY=if(row<=middle)column==row||column==n-1-row else column==middle
            if(onY){yCount[grid[row][column]]++;ySize++}else backgroundCount[grid[row][column]]++
        }
        var answer=n*n
        for(y in 0..2)for(background in 0..2)if(y!=background){
            answer=minOf(answer,ySize-yCount[y]+(n*n-ySize)-backgroundCount[background])
        }
        return answer
    }
}
