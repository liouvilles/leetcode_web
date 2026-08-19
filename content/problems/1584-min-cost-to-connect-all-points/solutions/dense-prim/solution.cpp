class Solution {
    public: int minCostConnectPoints(vector<vector<int>>& points){
        int n=points.size(),answer=0;
        vector<int> distance(n,INT_MAX);
        vector<bool> used(n);
        distance[0]=0;
        for(int count=0;count<n;++count){
            int node=-1;
            for(int i=0;i<n;++i)if(!used[i]&&(node==-1||distance[i]<distance[node]))node=i;
            used[node]=true;
            answer+=distance[node];
            for(int next=0;next<n;++next)if(!used[next]){
                int cost=abs(points[node][0]-points[next][0])+abs(points[node][1]-points[next][1]);
                distance[next]=min(distance[next],cost);
            }
        }
        return answer;
    }
};
