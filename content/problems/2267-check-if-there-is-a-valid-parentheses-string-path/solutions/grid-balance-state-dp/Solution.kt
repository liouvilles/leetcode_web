class Solution {
    fun hasValidPath(grid:Array<CharArray>):Boolean{
        val rows=grid.size;
        val columns=grid[0].size;
        val length=rows+columns-1;
        if(length%2==1||grid[0][0]!='('||grid[rows-1][columns-1]!=')')return false;
        val reachable=Array(rows){
            Array(columns){
                BooleanArray(length+2)
            }
        };
        reachable[0][0][1]=true;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(0,1));
        for(r in 0 until rows)for(c in 0 until columns)for(balance in 0..length)if(reachable[r][c][balance])for(direction in directions){
            val nr=r+direction[0];
            val nc=c+direction[1];
            if(nr>=rows||nc>=columns)continue;
            val next=balance+if(grid[nr][nc]=='(')1 else -1;
            if(next in 0..length)reachable[nr][nc][next]=true
        };
        return reachable[rows-1][columns-1][0]
    }
}
