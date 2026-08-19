class Solution {
    fun largestIsland(grid:Array<IntArray>):Int{
        val n=grid.size;
        var id=2;
        var answer=0;
        val area=mutableMapOf<Int,Int>();
        for(r in 0 until n)for(c in 0 until n)if(grid[r][c]==1){
            val size=paint(grid,r,c,id);
            area[id]=size;
            answer=maxOf(answer,size);
            id++
        };
        val directions=intArrayOf(-1,0,1,0,-1);
        for(r in 0 until n)for(c in 0 until n)if(grid[r][c]==0){
            var size=1;
            val seen=mutableSetOf<Int>();
            for(d in 0 until 4){
                val nr=r+directions[d];
                val nc=c+directions[d+1];
                if(nr in 0 until n&&nc in 0 until n&&grid[nr][nc]>1&&seen.add(grid[nr][nc]))size+=area[grid[nr][nc]]!!
            };
            answer=maxOf(answer,size)
        };
        return answer
    };
    private fun paint(grid:Array<IntArray>,r:Int,c:Int,id:Int):Int{
        if(r !in grid.indices||c !in grid.indices||grid[r][c]!=1)return 0;
        grid[r][c]=id;
        return 1+paint(grid,r+1,c,id)+paint(grid,r-1,c,id)+paint(grid,r,c+1,id)+paint(grid,r,c-1,id)
    }
}
