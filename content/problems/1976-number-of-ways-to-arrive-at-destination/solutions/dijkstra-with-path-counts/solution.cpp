class Solution {
    public: int countPaths(int n,vector<vector<int>>& roads){
        vector<vector<pair<int,int>>> graph(n);
        for(auto& road:roads){
            graph[road[0]].push_back({
                road[1],road[2]
            });
            graph[road[1]].push_back({
                road[0],road[2]
            });
        }
        vector<long long> distance(n,LLONG_MAX);
        vector<int> ways(n);
        priority_queue<pair<long long,int>,vector<pair<long long,int>>,greater<pair<long long,int>>> heap;
        distance[0]=0;
        ways[0]=1;
        heap.push({
            0,0
        });
        while(!heap.empty()){
            auto [currentDistance,node]=heap.top();
            heap.pop();
            if(currentDistance!=distance[node])continue;
            for(auto [next,weight]:graph[node]){
                long long nextDistance=currentDistance+weight;
                if(nextDistance<distance[next]){
                    distance[next]=nextDistance;
                    ways[next]=ways[node];
                    heap.push({
                        nextDistance,next
                    });
                }else if(nextDistance==distance[next])ways[next]=(ways[next]+ways[node])%1000000007;
            }
        }
        return ways[n-1];
    }
};
