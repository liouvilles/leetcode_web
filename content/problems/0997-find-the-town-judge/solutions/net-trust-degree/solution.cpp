class Solution {
    public: int findJudge(int n,vector<vector<int>>& trust){
        vector<int> score(n+1);
        for(auto& relation:trust){
            --score[relation[0]];
            ++score[relation[1]];
        }
        for(int person=1;person<=n;++person)if(score[person]==n-1)return person;
        return -1;
    }
};
