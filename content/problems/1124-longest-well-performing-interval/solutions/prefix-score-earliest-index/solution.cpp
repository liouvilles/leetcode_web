class Solution {
    public: int longestWPI(vector<int>& hours){
        unordered_map<int,int> earliest;
        int score=0,answer=0;
        for(int i=0;i<(int)hours.size();++i){
            score+=hours[i]>8?1:-1;
            if(score>0)answer=i+1;
            else if(earliest.count(score-1))answer=max(answer,i-earliest[score-1]);
            if(!earliest.count(score))earliest[score]=i;
        }
        return answer;
    }
};
