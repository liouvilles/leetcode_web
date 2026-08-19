class Solution {
    fun canMakeSquare(grid:Array<CharArray>):Boolean{
        for(row in 0..1)for(col in 0..1){
            var black=0;
            for(dr in 0..1)for(dc in 0..1)if(grid[row+dr][col+dc]=='B')black++;
            if(black!=2)return true
        };
        return false
    }
}
