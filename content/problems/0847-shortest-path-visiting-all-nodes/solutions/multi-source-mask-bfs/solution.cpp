class Solution {
    public: int shortestPathLength(vector<vector<int>>& graph){
        int n=graph.size(),target=(1<<n)-1;
        vector<vector<bool>> seen(n,vector<bool>(1<<n));
        queue<array<int,3>> pending;
        for(int node=0;node<n;++node){
            pending.push({
                node,1<<node,0
            });
            seen[node][1<<node]=true;
        }while(!pending.empty()){
            auto [node,mask,distance]=pending.front();
            pending.pop();
            if(mask==target)return distance;
            for(int next:graph[node]){
                int nextMask=mask|1<<next;
                if(!seen[next][nextMask]){
                    seen[next][nextMask]=true;
                    pending.push({
                        next,nextMask,distance+1
                    });
                }
            }
        }
        return -1;
    }
};
