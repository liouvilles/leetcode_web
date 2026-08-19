class Solution {
    public:vector<int> minOperationsQueries(int n,vector<vector<int>>& edges,vector<vector<int>>& queries){
        vector<vector<pair<int,int>>> graph(n);
        for(auto& edge:edges){
            graph[edge[0]].push_back({
                edge[1],edge[2]-1
            });
            graph[edge[1]].push_back({
                edge[0],edge[2]-1
            });
        }
        int levels=1;
        while((1<<levels)<=n)++levels;
        vector up(levels,vector<int>(n));
        vector<array<int,26>> prefix(n);
        vector<int> depth(n);
        fill(up[0].begin(),up[0].end(),-1);
        up[0][0]=0;
        queue<int> pending;
        pending.push(0);
        while(!pending.empty()){
            int node=pending.front();
            pending.pop();
            for(auto [next,weight]:graph[node]){
                if(next==up[0][node])continue;
                up[0][next]=node;
                depth[next]=depth[node]+1;
                prefix[next]=prefix[node];
                ++prefix[next][weight];
                pending.push(next);
            }
        }
        for(int bit=1;bit<levels;++bit)for(int node=0;node<n;++node)up[bit][node]=up[bit-1][up[bit-1][node]];
        auto lca=[&](int a,int b){
            if(depth[a]<depth[b])swap(a,b);
            int difference=depth[a]-depth[b];
            for(int bit=0;bit<levels;++bit)if(difference>>bit&1)a=up[bit][a];
            if(a==b)return a;
            for(int bit=levels-1;bit>=0;--bit)if(up[bit][a]!=up[bit][b]){
                a=up[bit][a];
                b=up[bit][b];
            }
            return up[0][a];
        };
        vector<int> answer;
        for(auto& query:queries){
            int u=query[0],v=query[1],ancestor=lca(u,v),length=depth[u]+depth[v]-2*depth[ancestor],maximum=0;
            for(int weight=0;weight<26;++weight)maximum=max(maximum,prefix[u][weight]+prefix[v][weight]-2*prefix[ancestor][weight]);
            answer.push_back(length-maximum);
        }
        return answer;
    }
};
