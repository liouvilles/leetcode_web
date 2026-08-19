class Solution {
    vector<int> locations;
    int finish;
    vector<vector<int>> memo;
    const int MOD=1000000007;
    int dfs(int city,int fuel){
        int& cached=memo[city][fuel];
        if(cached!=-1)return cached;
        long long answer=city==finish;
        for(int next=0;next<(int)locations.size();++next)if(next!=city){
            int cost=abs(locations[city]-locations[next]);
            if(cost<=fuel)answer+=dfs(next,fuel-cost);
        }
        return cached=answer%MOD;
    }
    public:int countRoutes(vector<int>& locations,int start,int finish,int fuel){
        this->locations=locations;
        this->finish=finish;
        memo.assign(locations.size(),vector<int>(fuel+1,-1));
        return dfs(start,fuel);
    }
};
