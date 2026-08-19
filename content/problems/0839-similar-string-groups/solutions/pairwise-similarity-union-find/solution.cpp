class Solution {
    struct DSU{
        vector<int> parent;
        int groups;
        DSU(int n):parent(n),groups(n){
            iota(parent.begin(),parent.end(),0);
        }
        int find(int x){
            return parent[x]==x?x:parent[x]=find(parent[x]);
        }
        void unite(int a,int b){
            a=find(a);
            b=find(b);
            if(a!=b){
                parent[b]=a;
                --groups;
            }
        }
    };
    bool similar(string& a,string& b){
        int differences=0;
        for(int i=0;i<(int)a.size();++i)if(a[i]!=b[i]&&++differences>2)return false;
        return true;
    }
    public:int numSimilarGroups(vector<string>& strs){
        DSU dsu(strs.size());
        for(int i=0;i<(int)strs.size();++i)for(int j=i+1;j<(int)strs.size();++j)if(similar(strs[i],strs[j]))dsu.unite(i,j);
        return dsu.groups;
    }
};
