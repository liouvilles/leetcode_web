class Solution {
    public:int maximumScore(vector<int>& scores,vector<vector<int>>& edges){
        vector<vector<int>> neighbors(scores.size());
        for(auto& edge:edges){
            neighbors[edge[0]].push_back(edge[1]);
            neighbors[edge[1]].push_back(edge[0]);
        }
        for(auto& list:neighbors)sort(list.begin(),list.end(),[&](int a,int b){
            return scores[a]>scores[b];
        });
        int answer=-1;
        for(auto& edge:edges){
            int b=edge[0],c=edge[1];
            for(int ai=0;ai<min(3,(int)neighbors[b].size());++ai)for(int di=0;di<min(3,(int)neighbors[c].size());++di){
                int a=neighbors[b][ai],d=neighbors[c][di];
                if(a!=c&&d!=b&&a!=d)answer=max(answer,scores[a]+scores[b]+scores[c]+scores[d]);
            }
        }
        return answer;
    }
};
