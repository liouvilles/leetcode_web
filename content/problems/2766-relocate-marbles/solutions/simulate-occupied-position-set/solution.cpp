class Solution {
    public:vector<int> relocateMarbles(vector<int>& nums,vector<int>& moveFrom,vector<int>& moveTo){
        unordered_set<int> positions(nums.begin(),nums.end());
        for(int i=0;i<(int)moveFrom.size();++i){
            positions.erase(moveFrom[i]);
            positions.insert(moveTo[i]);
        }
        vector<int> answer(positions.begin(),positions.end());
        sort(answer.begin(),answer.end());
        return answer;
    }
};
