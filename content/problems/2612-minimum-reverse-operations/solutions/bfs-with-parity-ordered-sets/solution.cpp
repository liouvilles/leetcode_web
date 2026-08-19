class Solution {
    public:vector<int> minReverseOperations(int n,int p,vector<int>& banned,int k){
        vector<bool> forbidden(n);
        for(int index:banned)forbidden[index]=true;
        set<int> unvisited[2];
        for(int index=0;index<n;++index)if(index!=p&&!forbidden[index])unvisited[index&1].insert(index);
        vector<int> distance(n,-1);
        distance[p]=0;
        queue<int> pending;
        pending.push(p);
        while(!pending.empty()){
            int node=pending.front();
            pending.pop();
            int left=max(0,node-k+1),right=min(node,n-k);
            int minimum=2*left+k-1-node,maximum=2*right+k-1-node;
            auto& candidates=unvisited[minimum&1];
            auto iterator=candidates.lower_bound(minimum);
            while(iterator!=candidates.end()&&*iterator<=maximum){
                int destination=*iterator;
                iterator=candidates.erase(iterator);
                distance[destination]=distance[node]+1;
                pending.push(destination);
            }
        }
        return distance;
    }
};
