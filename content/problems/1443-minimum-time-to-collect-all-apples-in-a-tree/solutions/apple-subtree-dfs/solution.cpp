class Solution {
    int dfs(int node,int parent,vector<vector<int>>& graph,vector<bool>& hasApple){
        int cost=0;
        for(int child:graph[node])if(child!=parent){
            int childCost=dfs(child,node,graph,hasApple);
            if(childCost||hasApple[child])cost+=childCost+2;
        }
        return cost;
    }
    public:int minTime(int n,vector<vector<int>>& edges,vector<bool>& hasApple){
        vector<vector<int>> graph(n);
        for(auto& edge:edges){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        return dfs(0,-1,graph,hasApple);
    }
};
