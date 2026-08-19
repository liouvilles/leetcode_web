class Solution {
    public: bool isToeplitzMatrix(vector<vector<int>>& matrix){
        for(int row=1;row<(int)matrix.size();++row)for(int column=1;column<(int)matrix[0].size();++column)if(matrix[row][column]!=matrix[row-1][column-1])return false;
        return true;
    }
};
