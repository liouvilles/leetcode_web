class Solution {
    public:bool isPossible(int n,vector<vector<int>>& edges){
        vector<unordered_set<int>> graph(n);
        for(auto& edge:edges){
            int a=edge[0]-1,b=edge[1]-1;
            graph[a].insert(b);
            graph[b].insert(a);
        }
        vector<int> odd;
        for(int i=0;i<n;++i)if(graph[i].size()%2)odd.push_back(i);
        auto missing=[&](int a,int b){
            return !graph[a].count(b);
        };
        if(odd.empty())return true;
        if(odd.size()==2){
            int a=odd[0],b=odd[1];
            if(missing(a,b))return true;
            for(int c=0;c<n;++c)if(c!=a&&c!=b&&missing(a,c)&&missing(b,c))return true;
            return false;
        }
        if(odd.size()!=4)return false;
        int a=odd[0],b=odd[1],c=odd[2],d=odd[3];
        return missing(a,b)&&missing(c,d)||missing(a,c)&&missing(b,d)||missing(a,d)&&missing(b,c);
    }
};
