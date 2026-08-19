class Solution {
    public: vector<vector<int>> imageSmoother(vector<vector<int>>& img){
        int rows=img.size(),columns=img[0].size();
        vector<vector<int>> answer(rows,vector<int>(columns));
        for(int row=0;row<rows;++row)for(int column=0;column<columns;++column){
            int sum=0,count=0;
            for(int dr=-1;dr<=1;++dr)for(int dc=-1;dc<=1;++dc){
                int r=row+dr,c=column+dc;
                if(r>=0&&r<rows&&c>=0&&c<columns){
                    sum+=img[r][c];
                    ++count;
                }
            }
            answer[row][column]=sum/count;
        }
        return answer;
    }
};
