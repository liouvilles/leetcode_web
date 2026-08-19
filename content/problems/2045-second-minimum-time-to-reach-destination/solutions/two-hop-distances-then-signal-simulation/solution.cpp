class Solution {
    public: int secondMinimum(int n,vector<vector<int>>& edges,int time,int change){
        vector<vector<int>> graph(n+1);
        for(auto& edge:edges){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        const int INF=1000000;
        vector<int> first(n+1,INF),second(n+1,INF);
        queue<pair<int,int>> pending;
        first[1]=0;
        pending.push({
            1,0
        });
        while(!pending.empty()){
            auto [node,distance]=pending.front();
            pending.pop();
            for(int next:graph[node]){
                int candidate=distance+1;
                if(candidate<first[next]){
                    second[next]=first[next];
                    first[next]=candidate;
                    pending.push({
                        next,candidate
                    });
                }else if(candidate>first[next]&&candidate<second[next]){
                    second[next]=candidate;
                    pending.push({
                        next,candidate
                    });
                }
            }
        }
        int current=0;
        for(int step=0;step<second[n];++step){
            if((current/change)%2)current=(current/change+1)*change;
            current+=time;
        }
        return current;
    }
};
