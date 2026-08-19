class Solution {
    fun numRookCaptures(board:Array<CharArray>):Int{
        var row=0;
        var column=0;
        for(r in 0..7)for(c in 0..7)if(board[r][c]=='R'){
            row=r;
            column=c
        };
        var captures=0;
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        for(d in directions){
            var r=row+d[0];
            var c=column+d[1];
            while(r in 0..7&&c in 0..7&&board[r][c]=='.'){
                r+=d[0];
                c+=d[1]
            };
            if(r in 0..7&&c in 0..7&&board[r][c]=='p')captures++
        };
        return captures
    }
}
