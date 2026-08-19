class Solution {
    vector<int> parent;
    int find(int node){
        return parent[node]==node?node:parent[node]=find(parent[node]);
    }
    public:int makeConnected(int n,vector<vector<int>>& connections){
        if((int)connections.size()<n-1)return -1;
        parent.resize(n);
        iota(parent.begin(),parent.end(),0);
        for(auto& edge:connections){
            int a=find(edge[0]),b=find(edge[1]);
            if(a!=b)parent[b]=a;
        }
        int components=0;
        for(int i=0;i<n;++i)components+=find(i)==i;
        return components-1;
    }
};
