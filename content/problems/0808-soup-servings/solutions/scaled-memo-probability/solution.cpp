class Solution {
    vector<vector<double>> memo;
    double dfs(int a,int b){
        if(a<=0&&b<=0)return .5;
        if(a<=0)return 1;
        if(b<=0)return 0;
        double& result=memo[a][b];
        if(result>=0)return result;
        return result=.25*(dfs(a-4,b)+dfs(a-3,b-1)+dfs(a-2,b-2)+dfs(a-1,b-3));
    }
    public:double soupServings(int n){
        if(n>4800)return 1;
        int units=(n+24)/25;
        memo.assign(units+1,vector<double>(units+1,-1));
        return dfs(units,units);
    }
};
