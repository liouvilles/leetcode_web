class Solution {
    fun goodSubsetofBinaryMatrix(grid:Array<IntArray>):List<Int>{
        val cols=grid[0].size;
        val limit=1 shl cols;
        val first=IntArray(limit){
            -1
        };
        for(row in grid.indices){
            var mask=0;
            for(col in 0 until cols)mask=mask or (grid[row][col] shl col);
            if(mask==0)return listOf(row);
            if(first[mask]==-1)first[mask]=row
        };
        for(a in 1 until limit)if(first[a]!=-1)for(b in a+1 until limit)if(first[b]!=-1&&(a and b)==0){
            val x=first[a];
            val y=first[b];
            return listOf(minOf(x,y),maxOf(x,y))
        };
        return emptyList()
    }
}
