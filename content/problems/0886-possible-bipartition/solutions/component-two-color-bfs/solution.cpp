class Solution {
    public: bool possibleBipartition(int n,vector<vector<int>>& dislikes){
        vector<vector<int>> graph(n+1);
        for(auto& edge:dislikes){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> color(n+1);
        for(int start=1;start<=n;++start)if(!color[start]){
            queue<int> pending;
            pending.push(start);
            color[start]=1;
            while(!pending.empty()){
                int node=pending.front();
                pending.pop();
                for(int next:graph[node])if(!color[next]){
                    color[next]=-color[node];
                    pending.push(next);
                }else if(color[next]==color[node])return false;
            }
        }
        return true;
    }
};
