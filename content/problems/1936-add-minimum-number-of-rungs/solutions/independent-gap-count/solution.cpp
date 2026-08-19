class Solution {
    public: int addRungs(vector<int>& rungs,int dist){
        int answer=0,previous=0;
        for(int rung:rungs){
            answer+=(rung-previous-1)/dist;
            previous=rung;
        }
        return answer;
    }
};
