class Solution {
    fun shortestPathBinaryMatrix(grid:Array<IntArray>):Int{
        val n=grid.size;
        if(grid[0][0]!=0||grid[n-1][n-1]!=0)return -1;
        val queue=java.util.ArrayDeque<IntArray>();
        queue.addLast(intArrayOf(0,0,1));
        grid[0][0]=1;
        while(queue.isNotEmpty()){
            val cell=queue.removeFirst();
            if(cell[0]==n-1&&cell[1]==n-1)return cell[2];
            for(dr in -1..1)for(dc in -1..1){
                val r=cell[0]+dr;
                val c=cell[1]+dc;
                if((dr!=0||dc!=0)&&r in 0 until n&&c in 0 until n&&grid[r][c]==0){
                    grid[r][c]=1;
                    queue.addLast(intArrayOf(r,c,cell[2]+1))
                }
            }
        };
        return -1
    }
}
