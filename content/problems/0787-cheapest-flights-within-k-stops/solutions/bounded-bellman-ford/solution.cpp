class Solution {
    public: int findCheapestPrice(int n,vector<vector<int>>& flights,int src,int dst,int k){
        const int infinity=1000000000;
        vector<int> cost(n,infinity);
        cost[src]=0;
        for(int step=0;step<=k;++step){
            vector<int> next=cost;
            for(auto& flight:flights)if(cost[flight[0]]<infinity)next[flight[1]]=min(next[flight[1]],cost[flight[0]]+flight[2]);
            cost.swap(next);
        }
        return cost[dst]==infinity?-1:cost[dst];
    }
};
