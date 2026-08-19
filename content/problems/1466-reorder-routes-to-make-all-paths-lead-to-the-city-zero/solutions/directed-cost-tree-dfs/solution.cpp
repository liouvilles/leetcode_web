class Solution {
    int dfs(int node,int parent,vector<vector<pair<int,int>>>& graph){
        int answer=0;
        for(auto [child,cost]:graph[node])if(child!=parent)answer+=cost+dfs(child,node,graph);
        return answer;
    }
    public:int minReorder(int n,vector<vector<int>>& connections){
        vector<vector<pair<int,int>>> graph(n);
        for(auto& edge:connections){
            graph[edge[0]].push_back({
                edge[1],1
            });
            graph[edge[1]].push_back({
                edge[0],0
            });
        }
        return dfs(0,-1,graph);
    }
};
