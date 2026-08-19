class Solution {
    public: vector<string> findRelativeRanks(vector<int>& score){
        vector<int> indices(score.size());
        iota(indices.begin(),indices.end(),0);
        sort(indices.begin(),indices.end(),[&](int a,int b){
            return score[a]>score[b];
        });
        vector<string> answer(score.size());
        string medals[3]={
            "Gold Medal","Silver Medal","Bronze Medal"
        };
        for(int rank=0;rank<(int)indices.size();++rank)answer[indices[rank]]=rank<3?medals[rank]:to_string(rank+1);
        return answer;
    }
};
