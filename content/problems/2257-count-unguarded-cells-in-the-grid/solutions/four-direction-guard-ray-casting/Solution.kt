class Solution {
    fun countUnguarded(m:Int,n:Int,guards:Array<IntArray>,walls:Array<IntArray>):Int{
        val state=Array(m){
            IntArray(n)
        };
        for(wall in walls)state[wall[0]][wall[1]]=2;
        for(guard in guards)state[guard[0]][guard[1]]=3;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        for(guard in guards)for(direction in directions){
            var row=guard[0]+direction[0];
            var column=guard[1]+direction[1];
            while(row in 0 until m&&column in 0 until n&&state[row][column]!=2&&state[row][column]!=3){
                state[row][column]=1;
                row+=direction[0];
                column+=direction[1]
            }
        };
        return state.sumOf{
            row->row.count{
                it==0
            }
        }
    }
}
