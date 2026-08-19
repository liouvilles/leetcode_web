class Solution {
    private lateinit var grid:Array<IntArray>;
    private lateinit var fire:Array<IntArray>;
    private var rows=0;
    private var columns=0;
    private val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
    private fun can(wait:Int):Boolean{
        if(wait>=fire[0][0])return false;
        val seen=Array(rows){
            BooleanArray(columns)
        };
        val queue=java.util.ArrayDeque<IntArray>();
        queue.add(intArrayOf(0,0,wait));
        seen[0][0]=true;
        while(queue.isNotEmpty()){
            val state=queue.removeFirst();
            for(direction in directions){
                val r=state[0]+direction[0];
                val c=state[1]+direction[1];
                val arrival=state[2]+1;
                if(r !in 0 until rows||c !in 0 until columns||seen[r][c]||grid[r][c]==2)continue;
                if(r==rows-1&&c==columns-1){
                    if(arrival<=fire[r][c])return true;
                    continue
                };
                if(arrival>=fire[r][c])continue;
                seen[r][c]=true;
                queue.add(intArrayOf(r,c,arrival))
            }
        };
        return false
    };
    fun maximumMinutes(grid:Array<IntArray>):Int{
        this.grid=grid;
        rows=grid.size;
        columns=grid[0].size;
        val infinity=1_100_000_000;
        fire=Array(rows){
            IntArray(columns){
                infinity
            }
        };
        val queue=java.util.ArrayDeque<IntArray>();
        for(r in 0 until rows)for(c in 0 until columns)if(grid[r][c]==1){
            fire[r][c]=0;
            queue.add(intArrayOf(r,c))
        };
        while(queue.isNotEmpty()){
            val cell=queue.removeFirst();
            for(direction in directions){
                val r=cell[0]+direction[0];
                val c=cell[1]+direction[1];
                if(r in 0 until rows&&c in 0 until columns&&grid[r][c]!=2&&fire[r][c]==infinity){
                    fire[r][c]=fire[cell[0]][cell[1]]+1;
                    queue.add(intArrayOf(r,c))
                }
            }
        };
        if(!can(0))return -1;
        if(can(1_000_000_000))return 1_000_000_000;
        var left=0;
        var right=1_000_000_000;
        while(left<right){
            val middle=left+(right-left+1)/2;
            if(can(middle))left=middle else right=middle-1
        };
        return left
    }
}
