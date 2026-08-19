class Solution {
    vector<vector<int>>* grid;
    int rows,columns;
    void flood(int r,int c){
        if(r<0||r>=rows||c<0||c>=columns||(*grid)[r][c])return;
        (*grid)[r][c]=1;
        flood(r+1,c);
        flood(r-1,c);
        flood(r,c+1);
        flood(r,c-1);
    }
    public:int closedIsland(vector<vector<int>>& input){
        grid=&input;
        rows=input.size();
        columns=input[0].size();
        for(int r=0;r<rows;++r){
            flood(r,0);
            flood(r,columns-1);
        }
        for(int c=0;c<columns;++c){
            flood(0,c);
            flood(rows-1,c);
        }
        int answer=0;
        for(int r=1;r<rows-1;++r)for(int c=1;c<columns-1;++c)if(!input[r][c]){
            ++answer;
            flood(r,c);
        }
        return answer;
    }
};
