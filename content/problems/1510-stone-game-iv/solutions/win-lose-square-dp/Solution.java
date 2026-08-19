class Solution {
    public boolean winnerSquareGame(int n){
        boolean[] dp=new boolean[n+1];
        for(int stones=1;stones<=n;stones++)for(int root=1;root*root<=stones;root++)if(!dp[stones-root*root]){
            dp[stones]=true;
            break;
        }
        return dp[n];
    }
}
