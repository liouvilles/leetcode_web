class Solution {
    struct DSU{
        vector<int> parent,rank;
        DSU(int n):parent(n),rank(n){
            iota(parent.begin(),parent.end(),0);
        }
        int find(int x){
            return parent[x]==x?x:parent[x]=find(parent[x]);
        }
        void unite(int a,int b){
            a=find(a);
            b=find(b);
            if(a==b)return;
            if(rank[a]<rank[b])swap(a,b);
            parent[b]=a;
            if(rank[a]==rank[b])++rank[a];
        }
    };
    public:vector<bool> distanceLimitedPathsExist(int n,vector<vector<int>>& edgeList,vector<vector<int>>& queries){
        sort(edgeList.begin(),edgeList.end(),[](auto& a,auto& b){
            return a[2]<b[2];
        });
        vector<int> order(queries.size());
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return queries[a][2]<queries[b][2];
        });
        vector<bool> answer(queries.size());
        DSU dsu(n);
        int edgeIndex=0;
        for(int queryIndex:order){
            int limit=queries[queryIndex][2];
            while(edgeIndex<(int)edgeList.size()&&edgeList[edgeIndex][2]<limit){
                dsu.unite(edgeList[edgeIndex][0],edgeList[edgeIndex][1]);
                ++edgeIndex;
            }
            answer[queryIndex]=dsu.find(queries[queryIndex][0])==dsu.find(queries[queryIndex][1]);
        }
        return answer;
    }
};
