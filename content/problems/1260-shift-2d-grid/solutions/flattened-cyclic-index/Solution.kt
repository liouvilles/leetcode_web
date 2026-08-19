class Solution {
    fun shiftGrid(grid:Array<IntArray>,kValue:Int):List<List<Int>>{
        val rows=grid.size;
        val columns=grid[0].size;
        val total=rows*columns;
        val k=kValue%total;
        val shifted=Array(rows){
            IntArray(columns)
        };
        for(index in 0 until total){
            val next=(index+k)%total;
            shifted[next/columns][next%columns]=grid[index/columns][index%columns]
        };
        return shifted.map{
            it.toList()
        }
    }
}
