class Solution {
    bool safe(int node,vector<vector<int>>& graph,vector<int>& color){
        if(color[node])return color[node]==2;
        color[node]=1;
        for(int next:graph[node])if(!safe(next,graph,color)){
            color[node]=3;
            return false;
        }
        color[node]=2;
        return true;
    }
    public:vector<int> eventualSafeNodes(vector<vector<int>>& graph){
        vector<int> color(graph.size()),answer;
        for(int node=0;node<(int)graph.size();++node)if(safe(node,graph,color))answer.push_back(node);
        return answer;
    }
};
