class Solution {
    using Edge=pair<int,int>;
    vector<long long> dijkstra(int start,vector<vector<Edge>>& graph){
        vector<long long> distance(graph.size(),LLONG_MAX);
        distance[start]=0;
        priority_queue<pair<long long,int>,vector<pair<long long,int>>,greater<pair<long long,int>>> queue;
        queue.push({
            0,start
        });
        while(!queue.empty()){
            auto [cost,node]=queue.top();
            queue.pop();
            if(cost!=distance[node])continue;
            for(auto [next,weight]:graph[node])if(cost+weight<distance[next]){
                distance[next]=cost+weight;
                queue.push({
                    distance[next],next
                });
            }
        }
        return distance;
    }
    public:long long minimumWeight(int n,vector<vector<int>>& edges,int src1,int src2,int dest){
        vector<vector<Edge>> graph(n),reverse(n);
        for(auto& edge:edges){
            graph[edge[0]].push_back({
                edge[1],edge[2]
            });
            reverse[edge[1]].push_back({
                edge[0],edge[2]
            });
        }
        auto first=dijkstra(src1,graph),second=dijkstra(src2,graph),suffix=dijkstra(dest,reverse);
        long long answer=LLONG_MAX;
        for(int i=0;i<n;++i)if(first[i]!=LLONG_MAX&&second[i]!=LLONG_MAX&&suffix[i]!=LLONG_MAX)answer=min(answer,first[i]+second[i]+suffix[i]);
        return answer==LLONG_MAX?-1:answer;
    }
};
