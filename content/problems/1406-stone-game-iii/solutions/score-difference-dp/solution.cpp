class Solution {
    public: string stoneGameIII(vector<int>& stoneValue){
        int n=stoneValue.size();
        vector<int> dp(n+1);
        for(int i=n-1;i>=0;--i){
            dp[i]=INT_MIN;
            int sum=0;
            for(int take=1;take<=3&&i+take<=n;++take){
                sum+=stoneValue[i+take-1];
                dp[i]=max(dp[i],sum-dp[i+take]);
            }
        }
        return dp[0]>0?"Alice":dp[0]<0?"Bob":"Tie";
    }
};
