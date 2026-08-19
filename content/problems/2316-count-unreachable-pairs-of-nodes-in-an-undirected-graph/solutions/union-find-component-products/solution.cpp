class Solution {
    vector<int> parent,size;
    int find(int x){
        return parent[x]==x?x:parent[x]=find(parent[x]);
    }
    void unite(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b)return;
        if(size[a]<size[b])swap(a,b);
        parent[b]=a;
        size[a]+=size[b];
    }
    public:long long countPairs(int n,vector<vector<int>>& edges){
        parent.resize(n);
        iota(parent.begin(),parent.end(),0);
        size.assign(n,1);
        for(auto& edge:edges)unite(edge[0],edge[1]);
        long long answer=0,seen=0;
        for(int i=0;i<n;++i)if(find(i)==i){
            answer+=seen*size[i];
            seen+=size[i];
        }
        return answer;
    }
};
