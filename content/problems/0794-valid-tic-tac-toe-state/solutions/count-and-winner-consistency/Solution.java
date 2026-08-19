class Solution {
    public boolean validTicTacToe(String[] board){
        int x=0,o=0;
        for(String row:board)for(char c:row.toCharArray()){
            if(c=='X')x++;
            else if(c=='O')o++;
        }
        if(x!=o&&x!=o+1)return false;
        boolean xWins=wins(board,'X'),oWins=wins(board,'O');
        if(xWins&&oWins)return false;
        if(xWins&&x!=o+1)return false;
        if(oWins&&x!=o)return false;
        return true;
    }
    private boolean wins(String[] board,char player){
        for(int i=0;i<3;i++)if(board[i].charAt(0)==player&&board[i].charAt(1)==player&&board[i].charAt(2)==player||board[0].charAt(i)==player&&board[1].charAt(i)==player&&board[2].charAt(i)==player)return true;
        return board[0].charAt(0)==player&&board[1].charAt(1)==player&&board[2].charAt(2)==player||board[0].charAt(2)==player&&board[1].charAt(1)==player&&board[2].charAt(0)==player;
    }
}
