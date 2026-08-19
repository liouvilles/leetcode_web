class Solution {
    public: vector<int> restoreArray(vector<vector<int>>& adjacentPairs){
        unordered_map<int,vector<int>> graph;
        for(auto& pair:adjacentPairs){
            graph[pair[0]].push_back(pair[1]);
            graph[pair[1]].push_back(pair[0]);
        }
        int start=0;
        bool found=false;
        for(auto& pair:adjacentPairs){
            for(int value:pair)if(graph[value].size()==1){
                start=value;
                found=true;
                break;
            }
            if(found)break;
        }
        vector<int> answer(graph.size());
        answer[0]=start;
        for(int i=1;i<(int)answer.size();++i){
            auto& neighbors=graph[answer[i-1]];
            answer[i]=neighbors[0];
            if(i>1&&answer[i]==answer[i-2])answer[i]=neighbors[1];
        }
        return answer;
    }
};
