class Solution {
    fun countSubmatrices(grid:Array<IntArray>,k:Int):Int{
        val columnSums=LongArray(grid[0].size)
        var answer=0
        for(row in grid){
            var prefix=0L
            for(column in row.indices){
                columnSums[column]+=row[column]
                prefix+=columnSums[column]
                if(prefix<=k)answer++
            }
        }
        return answer
    }
}
