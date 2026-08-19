class Solution {
    public: vector<int> gardenNoAdj(int n,vector<vector<int>>& paths){
        vector<vector<int>> graph(n);
        for(auto& edge:paths){
            graph[edge[0]-1].push_back(edge[1]-1);
            graph[edge[1]-1].push_back(edge[0]-1);
        }
        vector<int> colors(n);
        for(int garden=0;garden<n;++garden){
            bool used[5]={
            };
            for(int neighbor:graph[garden])used[colors[neighbor]]=true;
            for(int color=1;color<=4;++color)if(!used[color]){
                colors[garden]=color;
                break;
            }
        }
        return colors;
    }
};
