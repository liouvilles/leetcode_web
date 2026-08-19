class Solution {
    public: int networkDelayTime(vector<vector<int>>& times,int n,int k){
        vector<vector<pair<int,int>>> graph(n+1);
        for(auto& edge:times)graph[edge[0]].push_back({
            edge[1],edge[2]
        });
        vector<int> distance(n+1,INT_MAX);
        distance[k]=0;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> heap;
        heap.push({
            0,k
        });
        while(!heap.empty()){
            auto [current,node]=heap.top();
            heap.pop();
            if(current!=distance[node])continue;
            for(auto [next,weight]:graph[node])if(current+weight<distance[next]){
                distance[next]=current+weight;
                heap.push({
                    distance[next],next
                });
            }
        }
        int answer=0;
        for(int node=1;node<=n;++node){
            if(distance[node]==INT_MAX)return -1;
            answer=max(answer,distance[node]);
        }
        return answer;
    }
};
