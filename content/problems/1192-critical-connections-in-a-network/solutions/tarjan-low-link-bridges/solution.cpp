class Solution {
    vector<vector<int>> graph,answer;
    vector<int> discovery,low;
    int timer=1;
    void dfs(int node,int parent){
        discovery[node]=low[node]=timer++;
        for(int next:graph[node]){
            if(next==parent)continue;
            if(!discovery[next]){
                dfs(next,node);
                low[node]=min(low[node],low[next]);
                if(low[next]>discovery[node])answer.push_back({
                    node,next
                });
            }else low[node]=min(low[node],discovery[next]);
        }
    }
    public:vector<vector<int>> criticalConnections(int n,vector<vector<int>>& connections){
        graph.assign(n,{
        });
        for(auto& edge:connections){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        discovery.assign(n,0);
        low.assign(n,0);
        answer.clear();
        timer=1;
        dfs(0,-1);
        return answer;
    }
};
