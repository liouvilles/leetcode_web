class Solution {
    public: int movesToChessboard(vector<vector<int>>& board){
        int n=board.size();
        for(int i=0;i<n;++i)for(int j=0;j<n;++j)if((board[0][0]^board[i][0]^board[0][j]^board[i][j])!=0)return -1;
        int rowSum=0,columnSum=0,rowMatches=0,columnMatches=0;
        for(int i=0;i<n;++i){
            rowSum+=board[0][i];
            columnSum+=board[i][0];
            rowMatches+=board[i][0]==i%2;
            columnMatches+=board[0][i]==i%2;
        }
        if(rowSum<n/2||rowSum>(n+1)/2||columnSum<n/2||columnSum>(n+1)/2)return -1;
        if(n%2){
            if(rowMatches%2)rowMatches=n-rowMatches;
            if(columnMatches%2)columnMatches=n-columnMatches;
        }else{
            rowMatches=min(rowMatches,n-rowMatches);
            columnMatches=min(columnMatches,n-columnMatches);
        }
        return(rowMatches+columnMatches)/2;
    }
};
