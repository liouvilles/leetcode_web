class Solution {
    struct UnionFind{
        vector<int> parent,size;
        UnionFind(int n):parent(n),size(n,1){iota(parent.begin(),parent.end(),0);}
        int find(int node){return parent[node]==node?node:parent[node]=find(parent[node]);}
        void unite(int first,int second){int a=find(first),b=find(second);if(a==b)return;if(size[a]<size[b])swap(a,b);parent[b]=a;size[a]+=size[b];}
    };
public:
    vector<int> minimumCost(int n,vector<vector<int>>& edges,vector<vector<int>>& query){
        UnionFind unionFind(n);
        for(auto& edge:edges)unionFind.unite(edge[0],edge[1]);
        vector<int> componentCost(n,-1);
        for(auto& edge:edges)componentCost[unionFind.find(edge[0])]&=edge[2];
        vector<int> answer;
        for(auto& item:query){int first=unionFind.find(item[0]),second=unionFind.find(item[1]);answer.push_back(first==second?componentCost[first]:-1);}
        return answer;
    }
};
