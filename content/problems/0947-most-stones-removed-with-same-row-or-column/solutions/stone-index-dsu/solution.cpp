class Solution {
    vector<int> parent;
    int find(int x){
        return parent[x]==x?x:parent[x]=find(parent[x]);
    }
    public:int removeStones(vector<vector<int>>& stones){
        int n=stones.size();
        parent.resize(n);
        iota(parent.begin(),parent.end(),0);
        for(int i=0;i<n;++i)for(int j=i+1;j<n;++j)if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
            int a=find(i),b=find(j);
            if(a!=b)parent[a]=b;
        }
        unordered_set<int> roots;
        for(int i=0;i<n;++i)roots.insert(find(i));
        return n-roots.size();
    }
};
