class Solution {
    public char[][] rotateTheBox(char[][] box){
        int rows=box.length,cols=box[0].length;
        for(int row=0;row<rows;row++){
            int empty=cols-1;
            for(int col=cols-1;col>=0;col--)if(box[row][col]=='*')empty=col-1;
            else if(box[row][col]=='#'){
                box[row][col]='.';
                box[row][empty--]='#';
            }
        }
        char[][] result=new char[cols][rows];
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)result[col][rows-1-row]=box[row][col];
        return result;
    }
}
