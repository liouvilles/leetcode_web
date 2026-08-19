class Solution {
    public:long long distinctNames(vector<string>& ideas){
        unordered_set<string> groups[26];
        for(string& idea:ideas)groups[idea[0]-'a'].insert(idea.substr(1));
        long long answer=0;
        for(int i=0;i<26;++i)for(int j=i+1;j<26;++j){
            int common=0;
            for(auto& suffix:groups[i])common+=groups[j].count(suffix);
            answer+=2LL*(groups[i].size()-common)*(groups[j].size()-common);
        }
        return answer;
    }
};
