class Solution {
    int factor(int value,int divisor){
        int count=0;
        while(value%divisor==0){
            ++count;
            value/=divisor;
        }
        return count;
    }
    public:int maxTrailingZeros(vector<vector<int>>& grid){
        int rows=grid.size(),columns=grid[0].size();
        vector<vector<int>> two(rows,vector<int>(columns)),five=two,rowTwo(rows,vector<int>(columns+1)),rowFive=rowTwo,columnTwo(rows+1,vector<int>(columns)),columnFive=columnTwo;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c){
            two[r][c]=factor(grid[r][c],2);
            five[r][c]=factor(grid[r][c],5);
            rowTwo[r][c+1]=rowTwo[r][c]+two[r][c];
            rowFive[r][c+1]=rowFive[r][c]+five[r][c];
            columnTwo[r+1][c]=columnTwo[r][c]+two[r][c];
            columnFive[r+1][c]=columnFive[r][c]+five[r][c];
        }
        int answer=0;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c){
            int ht[2]={
                rowTwo[r][c+1],rowTwo[r][columns]-rowTwo[r][c]
            },hf[2]={
                rowFive[r][c+1],rowFive[r][columns]-rowFive[r][c]
            },vt[2]={
                columnTwo[r+1][c],columnTwo[rows][c]-columnTwo[r][c]
            },vf[2]={
                columnFive[r+1][c],columnFive[rows][c]-columnFive[r][c]
            };
            for(int h=0;h<2;++h)for(int v=0;v<2;++v)answer=max(answer,min(ht[h]+vt[v]-two[r][c],hf[h]+vf[v]-five[r][c]));
        }
        return answer;
    }
};
