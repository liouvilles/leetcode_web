class Solution {
    public: vector<int> countSubgraphsForEachDiameter(int n,vector<vector<int>>& edges){
        vector<vector<int>> graph(n);
        for(auto& edge:edges){
            int a=edge[0]-1,b=edge[1]-1;
            graph[a].push_back(b);
            graph[b].push_back(a);
        }
        auto bfs=[&](int start,int mask){
            vector<int> distance(n,-1);
            queue<int> pending;
            pending.push(start);
            distance[start]=0;
            int farthest=start,count=0;
            while(!pending.empty()){
                int node=pending.front();
                pending.pop();
                ++count;
                if(distance[node]>distance[farthest])farthest=node;
                for(int next:graph[node])if((mask&(1<<next))&&distance[next]<0){
                    distance[next]=distance[node]+1;
                    pending.push(next);
                }
            }
            return array<int,3>{
                farthest,distance[farthest],count
            };
        };
        vector<int> answer(n-1);
        for(int mask=1;mask<(1<<n);++mask){
            int size=__builtin_popcount(mask);
            if(size<2)continue;
            int start=__builtin_ctz(mask);
            auto first=bfs(start,mask);
            if(first[2]!=size)continue;
            int diameter=bfs(first[0],mask)[1];
            ++answer[diameter-1];
        }
        return answer;
    }
};
