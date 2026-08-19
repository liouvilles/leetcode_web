class Solution {
public:
    vector<int> countPairsOfConnectableServers(vector<vector<int>>& edges,int signalSpeed){
        int n=edges.size()+1;
        vector<vector<pair<int,int>>> graph(n);
        for(auto& edge:edges){graph[edge[0]].push_back({edge[1],edge[2]});graph[edge[1]].push_back({edge[0],edge[2]});}
        vector<int> answer(n);
        function<int(int,int,long long)> count=[&](int node,int parent,long long distance){
            int result=distance%signalSpeed==0;
            for(auto [next,weight]:graph[node])if(next!=parent)result+=count(next,node,distance+weight);
            return result;
        };
        for(int server=0;server<n;++server){
            int previous=0;
            for(auto [next,weight]:graph[server]){
                int current=count(next,server,weight);
                answer[server]+=previous*current;
                previous+=current;
            }
        }
        return answer;
    }
};
