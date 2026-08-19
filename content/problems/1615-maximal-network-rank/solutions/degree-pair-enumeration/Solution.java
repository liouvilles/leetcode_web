class Solution {
    public int maximalNetworkRank(int n,int[][] roads){
        int[] degree=new int[n];
        boolean[][] connected=new boolean[n][n];
        for(int[] road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
            connected[road[0]][road[1]]=connected[road[1]][road[0]]=true;
        }
        int answer=0;
        for(int first=0;first<n;first++)for(int second=first+1;second<n;second++)answer=Math.max(answer,degree[first]+degree[second]-(connected[first][second]?1:0));
        return answer;
    }
}
