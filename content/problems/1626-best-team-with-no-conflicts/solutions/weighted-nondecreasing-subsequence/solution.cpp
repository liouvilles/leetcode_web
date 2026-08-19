class Solution {
    public: int bestTeamScore(vector<int>& scores,vector<int>& ages){
        vector<pair<int,int>> players;
        for(int i=0;i<(int)scores.size();++i)players.push_back({
            ages[i],scores[i]
        });
        sort(players.begin(),players.end());
        vector<int> dp(scores.size());
        int answer=0;
        for(int i=0;i<(int)players.size();++i){
            dp[i]=players[i].second;
            for(int j=0;j<i;++j)if(players[j].second<=players[i].second)dp[i]=max(dp[i],dp[j]+players[i].second);
            answer=max(answer,dp[i]);
        }
        return answer;
    }
};
