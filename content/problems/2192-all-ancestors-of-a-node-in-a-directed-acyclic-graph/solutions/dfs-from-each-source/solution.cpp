class Solution {
    public:vector<vector<int>> getAncestors(int n,vector<vector<int>>& edges){
        vector<vector<int>> graph(n),answer(n);
        for(auto& edge:edges)graph[edge[0]].push_back(edge[1]);
        for(int source=0;source<n;++source){
            vector<bool> seen(n);
            vector<int> stack=graph[source];
            while(!stack.empty()){
                int node=stack.back();
                stack.pop_back();
                if(seen[node])continue;
                seen[node]=true;
                answer[node].push_back(source);
                for(int next:graph[node])stack.push_back(next);
            }
        }
        return answer;
    }
};
