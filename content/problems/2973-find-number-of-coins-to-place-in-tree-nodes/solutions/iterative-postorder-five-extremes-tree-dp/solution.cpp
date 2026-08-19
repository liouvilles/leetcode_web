class Solution {
    void addExtreme(vector<long long>& values,long long value){
        values.push_back(value);
        if(values.size()>5){
            sort(values.begin(),values.end());
            values.erase(values.begin()+2);
        }
    }
    public:vector<long long> placedCoins(vector<vector<int>>& edges,vector<int>& cost){
        int n=cost.size();
        vector<vector<int>> graph(n);
        for(auto& edge:edges){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> parent(n,-1),order,stack={
            0
        },subtreeSize(n,1);
        parent[0]=0;
        order.reserve(n);
        while(!stack.empty()){
            int node=stack.back();
            stack.pop_back();
            order.push_back(node);
            for(int next:graph[node])if(parent[next]==-1){
                parent[next]=node;
                stack.push_back(next);
            }
        }
        vector<vector<long long>> extremes(n);
        vector<long long> answer(n);
        for(int index=n-1;index>=0;--index){
            int node=order[index];
            vector<long long> values;
            values.reserve(6);
            addExtreme(values,cost[node]);
            for(int next:graph[node])if(parent[next]==node){
                subtreeSize[node]+=subtreeSize[next];
                for(long long value:extremes[next])addExtreme(values,value);
            }
            sort(values.begin(),values.end());
            extremes[node]=values;
            if(subtreeSize[node]<3)answer[node]=1;
            else{
                int last=values.size()-1;
                long long largest=values[last]*values[last-1]*values[last-2];
                long long mixed=values[0]*values[1]*values[last];
                answer[node]=max({
                    0LL,largest,mixed
                });
            }
        }
        return answer;
    }
};
