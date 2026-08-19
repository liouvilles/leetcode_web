class Solution {
    public: vector<int> findOriginalArray(vector<int>& changed){
        if(changed.size()%2)return{
        };
        sort(changed.begin(),changed.end());
        unordered_map<int,int> frequency;
        for(int value:changed)++frequency[value];
        vector<int> answer;
        for(int value:changed)if(frequency[value]){
            if(!frequency[value*2])return{
            };
            --frequency[value];
            --frequency[value*2];
            answer.push_back(value);
        }
        return answer;
    }
};
