class Solution {
    public: vector<int> findDiagonalOrder(vector<vector<int>>& mat){
        int rows=mat.size(),cols=mat[0].size(),row=0,column=0,direction=1;
        vector<int> answer(rows*cols);
        for(int index=0;index<(int)answer.size();++index){
            answer[index]=mat[row][column];
            int nextRow=row-direction,nextColumn=column+direction;
            if(nextRow<0||nextRow==rows||nextColumn<0||nextColumn==cols){
                if(direction==1){
                    if(column+1<cols)++column;
                    else ++row;
                }else{
                    if(row+1<rows)++row;
                    else ++column;
                }
                direction=-direction;
            }else{
                row=nextRow;
                column=nextColumn;
            }
        }
        return answer;
    }
};
