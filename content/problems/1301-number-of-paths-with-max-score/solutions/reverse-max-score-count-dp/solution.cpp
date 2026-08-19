class Solution {
    public: vector<int> pathsWithMaxScore(vector<string>& board){
        int n=board.size(),mod=1000000007;
        vector<vector<int>> score(n,vector<int>(n,-1)),ways(n,vector<int>(n));
        score[n-1][n-1]=0;
        ways[n-1][n-1]=1;
        int directions[3][2]={
            {
                1,0
            },{
                0,1
            },{
                1,1
            }
        };
        for(int r=n-1;r>=0;--r)for(int c=n-1;c>=0;--c){
            char cell=board[r][c];
            if(cell=='S'||cell=='X')continue;
            int best=-1,count=0;
            for(auto& d:directions){
                int nr=r+d[0],nc=c+d[1];
                if(nr<n&&nc<n&&score[nr][nc]>=0){
                    if(score[nr][nc]>best){
                        best=score[nr][nc];
                        count=ways[nr][nc];
                    }else if(score[nr][nc]==best)count=(count+ways[nr][nc])%mod;
                }
            }
            if(best>=0){
                score[r][c]=best+(cell=='E'?0:cell-'0');
                ways[r][c]=count;
            }
        }
        return score[0][0]<0?vector<int>{
            0,0
        }:vector<int>{
            score[0][0],ways[0][0]
        };
    }
};
