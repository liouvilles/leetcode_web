class Solution {
    vector<vector<pair<int,int>>> graph;
    vector<int> values,visits;
    int maximumTime,answer=0;
    void dfs(int node,int used,int quality){
        if(!node)answer=max(answer,quality);
        for(auto [next,cost]:graph[node])if(used+cost<=maximumTime){
            int gain=visits[next]++?0:values[next];
            dfs(next,used+cost,quality+gain);
            --visits[next];
        }
    }
    public: int maximalPathQuality(vector<int>& values,vector<vector<int>>& edges,int maxTime){
        this->values=values;
        maximumTime=maxTime;
        graph.resize(values.size());
        for(auto& edge:edges){
            graph[edge[0]].push_back({
                edge[1],edge[2]
            });
            graph[edge[1]].push_back({
                edge[0],edge[2]
            });
        }
        visits.resize(values.size());
        visits[0]=1;
        dfs(0,0,values[0]);
        return answer;
    }
};
