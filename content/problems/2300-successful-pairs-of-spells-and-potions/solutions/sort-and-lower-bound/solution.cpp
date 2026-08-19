class Solution {
    public:vector<int> successfulPairs(vector<int>& spells,vector<int>& potions,long long success){
        sort(potions.begin(),potions.end());
        vector<int> answer;
        for(long long spell:spells){
            long long required=(success+spell-1)/spell;
            auto iterator=lower_bound(potions.begin(),potions.end(),required);
            answer.push_back(potions.end()-iterator);
        }
        return answer;
    }
};
