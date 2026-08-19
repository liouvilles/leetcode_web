class Solution {
    public: double maxProbability(int n,vector<vector<int>>& edges,vector<double>& succProb,int start,int end){
        vector<vector<pair<int,double>>> graph(n);
        for(int i=0;i<(int)edges.size();++i){
            graph[edges[i][0]].push_back({
                edges[i][1],succProb[i]
            });
            graph[edges[i][1]].push_back({
                edges[i][0],succProb[i]
            });
        }
        vector<double> best(n);
        best[start]=1;
        priority_queue<pair<double,int>> heap;
        heap.push({
            1,start
        });
        while(!heap.empty()){
            auto [probability,node]=heap.top();
            heap.pop();
            if(probability<best[node])continue;
            if(node==end)return probability;
            for(auto [next,edgeProbability]:graph[node]){
                double candidate=probability*edgeProbability;
                if(candidate>best[next]){
                    best[next]=candidate;
                    heap.push({
                        candidate,next
                    });
                }
            }
        }
        return 0;
    }
};
