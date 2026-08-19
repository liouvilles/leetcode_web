class Solution {
    public: vector<int> smallestSufficientTeam(vector<string>& reqSkills,vector<vector<string>>& people){
        unordered_map<string,int> skill;
        for(int i=0;i<(int)reqSkills.size();++i)skill[reqSkills[i]]=i;
        unordered_map<int,vector<int>> dp{
            {
                0,{
                }
            }
        };
        for(int person=0;person<(int)people.size();++person){
            int personMask=0;
            for(string& name:people[person])personMask|=1<<skill[name];
            auto snapshot=dp;
            for(auto& entry:snapshot){
                int next=entry.first|personMask;
                if(!dp.count(next)||dp[next].size()>entry.second.size()+1){
                    dp[next]=entry.second;
                    dp[next].push_back(person);
                }
            }
        }
        return dp[(1<<reqSkills.size())-1];
    }
};
