class Solution {
    public: int orderOfLargestPlusSign(int n,vector<vector<int>>& mines){
        vector<vector<bool>> blocked(n,vector<bool>(n));
        for(auto& mine:mines)blocked[mine[0]][mine[1]]=true;
        vector<vector<int>> dp(n,vector<int>(n,n));
        for(int r=0;r<n;++r){
            int count=0;
            for(int c=0;c<n;++c){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=min(dp[r][c],count);
            }
            count=0;
            for(int c=n-1;c>=0;--c){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=min(dp[r][c],count);
            }
        }
        for(int c=0;c<n;++c){
            int count=0;
            for(int r=0;r<n;++r){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=min(dp[r][c],count);
            }
            count=0;
            for(int r=n-1;r>=0;--r){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=min(dp[r][c],count);
            }
        }
        int answer=0;
        for(auto& row:dp)answer=max(answer,*max_element(row.begin(),row.end()));
        return answer;
    }
};
