class Solution {
    vector<int> parent,rankValue;
    int find(int value){
        return parent[value]==value?value:parent[value]=find(parent[value]);
    }
    public:int findCircleNum(vector<vector<int>>& isConnected){
        int n=isConnected.size();
        parent.resize(n);
        rankValue.resize(n);
        iota(parent.begin(),parent.end(),0);
        int components=n;
        for(int i=0;i<n;++i)for(int j=i+1;j<n;++j)if(isConnected[i][j]){
            int a=find(i),b=find(j);
            if(a!=b){
                if(rankValue[a]<rankValue[b])swap(a,b);
                parent[b]=a;
                if(rankValue[a]==rankValue[b])++rankValue[a];
                --components;
            }
        }
        return components;
    }
};
