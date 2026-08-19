class Solution {
    public:int countCompleteComponents(int n,vector<vector<int>>& edges){
        vector<vector<int>> graph(n);
        for(auto& edge:edges){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n);
        int answer=0;
        for(int start=0;start<n;++start)if(!visited[start]){
            queue<int> pending;
            pending.push(start);
            visited[start]=true;
            int vertices=0,degreeSum=0;
            while(!pending.empty()){
                int node=pending.front();
                pending.pop();
                ++vertices;
                degreeSum+=graph[node].size();
                for(int next:graph[node])if(!visited[next]){
                    visited[next]=true;
                    pending.push(next);
                }
            }
            answer+=degreeSum==vertices*(vertices-1);
        }
        return answer;
    }
};
