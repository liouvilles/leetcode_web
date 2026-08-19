class Graph {
    const long long INF=1LL<<50;
    vector<vector<long long>> distance;
    public:Graph(int n,vector<vector<int>>& edges):distance(n,vector<long long>(n,INF)){
        for(int i=0;i<n;++i)distance[i][i]=0;
        for(auto& edge:edges)distance[edge[0]][edge[1]]=min(distance[edge[0]][edge[1]],(long long)edge[2]);
        for(int middle=0;middle<n;++middle)for(int from=0;from<n;++from)for(int to=0;to<n;++to)distance[from][to]=min(distance[from][to],distance[from][middle]+distance[middle][to]);
    }
    void addEdge(vector<int> edge){
        int from=edge[0],to=edge[1],weight=edge[2];
        if(weight>=distance[from][to])return;
        for(int start=0;start<(int)distance.size();++start)if(distance[start][from]<INF)for(int end=0;end<(int)distance.size();++end)if(distance[to][end]<INF)distance[start][end]=min(distance[start][end],distance[start][from]+weight+distance[to][end]);
    }
    int shortestPath(int node1,int node2){
        return distance[node1][node2]>=INF?-1:distance[node1][node2];
    }
};
