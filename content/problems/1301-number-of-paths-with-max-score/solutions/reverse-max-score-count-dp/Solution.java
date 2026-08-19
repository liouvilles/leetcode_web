class Solution {
    public int[] pathsWithMaxScore(List<String> board){
        int n=board.size(),mod=1000000007;
        int[][] score=new int[n][n],ways=new int[n][n];
        for(int[] row:score)Arrays.fill(row,-1);
        score[n-1][n-1]=0;
        ways[n-1][n-1]=1;
        int[][] directions={
            {
                1,0
            },{
                0,1
            },{
                1,1
            }
        };
        for(int r=n-1;r>=0;r--)for(int c=n-1;c>=0;c--){
            char cell=board.get(r).charAt(c);
            if(cell=='S'||cell=='X')continue;
            int best=-1,count=0;
            for(int[] d:directions){
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
        return score[0][0]<0?new int[]{
            0,0
        }:new int[]{
            score[0][0],ways[0][0]
        };
    }
}
