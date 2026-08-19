class Solution {
    public: int minCost(string colors,vector<int>& neededTime){
        int answer=0,kept=neededTime[0];
        for(int i=1;i<(int)colors.size();++i)if(colors[i]==colors[i-1]){
            answer+=min(kept,neededTime[i]);
            kept=max(kept,neededTime[i]);
        }else kept=neededTime[i];
        return answer;
    }
};
