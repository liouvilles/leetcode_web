class Solution {
    public:vector<vector<int>> resultGrid(vector<vector<int>>& image,int threshold){
        int rows=image.size(),columns=image[0].size();
        vector sum(rows,vector<int>(columns)),count(rows,vector<int>(columns));
        for(int top=0;top+2<rows;++top)for(int left=0;left+2<columns;++left){
            bool valid=true;
            for(int row=top;row<=top+2&&valid;++row)for(int column=left;column<left+2;++column)if(abs(image[row][column]-image[row][column+1])>threshold){
                valid=false;
                break;
            }
            for(int row=top;row<top+2&&valid;++row)for(int column=left;column<=left+2;++column)if(abs(image[row][column]-image[row+1][column])>threshold){
                valid=false;
                break;
            }
            if(!valid)continue;
            int average=0;
            for(int row=top;row<=top+2;++row)for(int column=left;column<=left+2;++column)average+=image[row][column];
            average/=9;
            for(int row=top;row<=top+2;++row)for(int column=left;column<=left+2;++column){
                sum[row][column]+=average;
                ++count[row][column];
            }
        }
        vector result(rows,vector<int>(columns));
        for(int row=0;row<rows;++row)for(int column=0;column<columns;++column)result[row][column]=count[row][column]?sum[row][column]/count[row][column]:image[row][column];
        return result;
    }
};
