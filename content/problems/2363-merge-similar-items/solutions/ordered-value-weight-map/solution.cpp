class Solution {
    public:vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1,vector<vector<int>>& items2){
        map<int,int> weights;
        for(auto& item:items1)weights[item[0]]+=item[1];
        for(auto& item:items2)weights[item[0]]+=item[1];
        vector<vector<int>> answer;
        for(auto [value,weight]:weights)answer.push_back({
            value,weight
        });
        return answer;
    }
};
