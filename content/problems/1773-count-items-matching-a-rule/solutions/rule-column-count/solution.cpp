class Solution {
    public: int countMatches(vector<vector<string>>& items,string ruleKey,string ruleValue){
        int index=ruleKey=="type"?0:ruleKey=="color"?1:2,answer=0;
        for(auto& item:items)answer+=item[index]==ruleValue;
        return answer;
    }
};
