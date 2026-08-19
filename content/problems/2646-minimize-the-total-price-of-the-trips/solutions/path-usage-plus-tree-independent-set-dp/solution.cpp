class Solution {
    vector<vector<int>> graph;
    vector<int> usage,price;
    bool addPath(int node,int parent,int target){
        if(node==target){
            ++usage[node];
            return true;
        }
        for(int next:graph[node])if(next!=parent&&addPath(next,node,target)){
            ++usage[node];
            return true;
        }
        return false;
    }
    pair<long long,long long> solve(int node,int parent){
        long long full=1LL*usage[node]*price[node],notHalf=full,half=full/2;
        for(int next:graph[node])if(next!=parent){
            auto [childNot,childHalf]=solve(next,node);
            notHalf+=min(childNot,childHalf);
            half+=childNot;
        }
        return {
            notHalf,half
        };
    }
    public:int minimumTotalPrice(int n,vector<vector<int>>& edges,vector<int>& inputPrice,vector<vector<int>>& trips){
        graph.assign(n,{
        });
        for(auto& edge:edges){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        usage.assign(n,0);
        price=inputPrice;
        for(auto& trip:trips)addPath(trip[0],-1,trip[1]);
        auto [notHalf,half]=solve(0,-1);
        return min(notHalf,half);
    }
};
