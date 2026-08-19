class Solution {
    vector<vector<int>> cost;
    vector<int> minimum;
    vector<vector<int>> memo;
    int dfs(int index,int mask){
        if(index==(int)cost.size()){
            int answer=0;
            for(int j=0;j<(int)minimum.size();++j)if(!(mask&(1<<j)))answer+=minimum[j];
            return answer;
        }
        int& cached=memo[index][mask];
        if(cached!=-1)return cached;
        int answer=INT_MAX;
        for(int j=0;j<(int)minimum.size();++j)answer=min(answer,cost[index][j]+dfs(index+1,mask|1<<j));
        return cached=answer;
    }
    public:int connectTwoGroups(vector<vector<int>>& cost){
        this->cost=cost;
        int second=cost[0].size();
        minimum.assign(second,INT_MAX);
        for(auto& row:cost)for(int j=0;j<second;++j)minimum[j]=min(minimum[j],row[j]);
        memo.assign(cost.size(),vector<int>(1<<second,-1));
        return dfs(0,0);
    }
};
