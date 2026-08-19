class Solution {
    public: vector<vector<int>> findFarmland(vector<vector<int>>& land){
        vector<vector<int>> answer;
        for(int row=0;row<(int)land.size();++row)for(int col=0;col<(int)land[0].size();++col)if(land[row][col]&&(!row||!land[row-1][col])&&(!col||!land[row][col-1])){
            int bottom=row,right=col;
            while(bottom+1<(int)land.size()&&land[bottom+1][col])++bottom;
            while(right+1<(int)land[0].size()&&land[row][right+1])++right;
            answer.push_back({
                row,col,bottom,right
            });
        }
        return answer;
    }
};
