class Solution {
    fun colorBorder(grid:Array<IntArray>,row:Int,col:Int,color:Int):Array<IntArray>{
        val visited=Array(grid.size){
            BooleanArray(grid[0].size)
        };
        val borders=mutableListOf<IntArray>();
        val original=grid[row][col];
        fun dfs(r:Int,c:Int){
            visited[r][c]=true;
            var border=false;
            val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
            for(d in directions){
                val nr=r+d[0];
                val nc=c+d[1];
                if(nr !in grid.indices||nc !in grid[0].indices||grid[nr][nc]!=original)border=true else if(!visited[nr][nc])dfs(nr,nc)
            };
            if(border)borders.add(intArrayOf(r,c))
        };
        dfs(row,col);
        for(cell in borders)grid[cell[0]][cell[1]]=color;
        return grid
    }
}
