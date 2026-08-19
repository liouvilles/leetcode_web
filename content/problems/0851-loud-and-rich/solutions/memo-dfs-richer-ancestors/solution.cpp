class Solution {
    vector<vector<int>> richerThan;
    vector<int> quiet,answer;
    int dfs(int person){
        if(answer[person]>=0)return answer[person];
        int best=person;
        for(int rich:richerThan[person]){
            int candidate=dfs(rich);
            if(quiet[candidate]<quiet[best])best=candidate;
        }
        return answer[person]=best;
    }
    public:vector<int> loudAndRich(vector<vector<int>>& richer,vector<int>& values){
        quiet=values;
        richerThan.assign(quiet.size(),{
        });
        for(auto& relation:richer)richerThan[relation[1]].push_back(relation[0]);
        answer.assign(quiet.size(),-1);
        for(int person=0;person<(int)quiet.size();++person)dfs(person);
        return answer;
    }
};
