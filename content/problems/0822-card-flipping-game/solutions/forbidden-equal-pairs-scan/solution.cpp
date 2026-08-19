class Solution {
    public: int flipgame(vector<int>& fronts,vector<int>& backs){
        unordered_set<int> forbidden;
        for(int i=0;i<(int)fronts.size();++i)if(fronts[i]==backs[i])forbidden.insert(fronts[i]);
        int answer=INT_MAX;
        for(int value:fronts)if(!forbidden.count(value))answer=min(answer,value);
        for(int value:backs)if(!forbidden.count(value))answer=min(answer,value);
        return answer==INT_MAX?0:answer;
    }
};
