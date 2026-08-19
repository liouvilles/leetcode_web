class Solution {
    public: vector<vector<int>> groupThePeople(vector<int>& groupSizes){
        unordered_map<int,vector<int>> pending;
        vector<vector<int>> answer;
        for(int person=0;person<(int)groupSizes.size();++person){
            int size=groupSizes[person];
            auto& group=pending[size];
            group.push_back(person);
            if((int)group.size()==size){
                answer.push_back(group);
                pending.erase(size);
            }
        }
        return answer;
    }
};
