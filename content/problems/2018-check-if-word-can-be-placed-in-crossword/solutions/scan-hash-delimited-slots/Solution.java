class Solution {
    private boolean matches(char[] line,int start,int end,String word){
        if(end-start!=word.length())return false;
        boolean forward=true,backward=true;
        for(int i=0;i<word.length();i++){
            char value=line[start+i];
            if(value!=' '&&value!=word.charAt(i))forward=false;
            if(value!=' '&&value!=word.charAt(word.length()-1-i))backward=false;
        }
        return forward||backward;
    }
    public boolean placeWordInCrossword(char[][] board,String word){
        int rows=board.length,cols=board[0].length;
        for(int row=0;row<rows;row++){
            int start=0;
            for(int col=0;col<=cols;col++)if(col==cols||board[row][col]=='#'){
                if(matches(board[row],start,col,word))return true;
                start=col+1;
            }
        }
        for(int col=0;col<cols;col++){
            char[] line=new char[rows];
            for(int row=0;row<rows;row++)line[row]=board[row][col];
            int start=0;
            for(int row=0;row<=rows;row++)if(row==rows||line[row]=='#'){
                if(matches(line,start,row,word))return true;
                start=row+1;
            }
        }
        return false;
    }
}
