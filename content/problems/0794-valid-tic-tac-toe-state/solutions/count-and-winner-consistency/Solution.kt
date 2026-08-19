class Solution {
    fun validTicTacToe(board:Array<String>):Boolean{
        var x=0;
        var o=0;
        for(row in board)for(c in row)if(c=='X')x++ else if(c=='O')o++;
        if(x!=o&&x!=o+1)return false;
        val xWins=wins(board,'X');
        val oWins=wins(board,'O');
        if(xWins&&oWins)return false;
        if(xWins&&x!=o+1)return false;
        if(oWins&&x!=o)return false;
        return true
    };
    private fun wins(board:Array<String>,player:Char):Boolean{
        for(i in 0 until 3)if(board[i][0]==player&&board[i][1]==player&&board[i][2]==player||board[0][i]==player&&board[1][i]==player&&board[2][i]==player)return true;
        return board[0][0]==player&&board[1][1]==player&&board[2][2]==player||board[0][2]==player&&board[1][1]==player&&board[2][0]==player
    }
}
