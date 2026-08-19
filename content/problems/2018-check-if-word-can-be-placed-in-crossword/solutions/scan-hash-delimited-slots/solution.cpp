class Solution {
    bool matches(vector<char>& line,int start,int end,string& word){
        if(end-start!=(int)word.size())return false;
        bool forward=true,backward=true;
        for(int i=0;i<(int)word.size();++i){
            char value=line[start+i];
            if(value!=' '&&value!=word[i])forward=false;
            if(value!=' '&&value!=word[word.size()-1-i])backward=false;
        }
        return forward||backward;
    }
    public: bool placeWordInCrossword(vector<vector<char>>& board,string word){
        int rows=board.size(),cols=board[0].size();
        for(auto& line:board){
            int start=0;
            for(int col=0;col<=cols;++col)if(col==cols||line[col]=='#'){
                if(matches(line,start,col,word))return true;
                start=col+1;
            }
        }
        for(int col=0;col<cols;++col){
            vector<char> line(rows);
            for(int row=0;row<rows;++row)line[row]=board[row][col];
            int start=0;
            for(int row=0;row<=rows;++row)if(row==rows||line[row]=='#'){
                if(matches(line,start,row,word))return true;
                start=row+1;
            }
        }
        return false;
    }
};
