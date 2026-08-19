class Solution {
    public:int longestCycle(vector<int>& edges){
        vector<int> visitedTime(edges.size());
        int time=1,answer=-1;
        for(int start=0;start<(int)edges.size();++start)if(!visitedTime[start]){
            int startTime=time,node=start;
            while(node!=-1&&!visitedTime[node]){
                visitedTime[node]=time++;
                node=edges[node];
            }
            if(node!=-1&&visitedTime[node]>=startTime)answer=max(answer,time-visitedTime[node]);
        }
        return answer;
    }
};
