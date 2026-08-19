class Solution {
public:
    int minimumOperationsToWriteY(vector<vector<int>>& grid){
        int n=grid.size(),middle=n/2,ySize=0,answer=n*n;
        int yCount[3]={},backgroundCount[3]={};
        for(int row=0;row<n;++row)for(int column=0;column<n;++column){
            bool onY=row<=middle?(column==row||column==n-1-row):column==middle;
            if(onY){++yCount[grid[row][column]];++ySize;}else ++backgroundCount[grid[row][column]];
        }
        for(int y=0;y<3;++y)for(int background=0;background<3;++background)if(y!=background){
            answer=min(answer,ySize-yCount[y]+n*n-ySize-backgroundCount[background]);
        }
        return answer;
    }
};
