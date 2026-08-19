class Solution {
    vector<vector<int>>* grid;
    int rows,columns;
    int dfs(int r,int c){
        if(r<0||r>=rows||c<0||c>=columns||!(*grid)[r][c])return 0;
        int gold=(*grid)[r][c];
        (*grid)[r][c]=0;
        int best=max({
            dfs(r+1,c),dfs(r-1,c),dfs(r,c+1),dfs(r,c-1)
        });
        (*grid)[r][c]=gold;
        return gold+best;
    }
    public:int getMaximumGold(vector<vector<int>>& input){
        grid=&input;
        rows=input.size();
        columns=input[0].size();
        int answer=0;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)answer=max(answer,dfs(r,c));
        return answer;
    }
};
