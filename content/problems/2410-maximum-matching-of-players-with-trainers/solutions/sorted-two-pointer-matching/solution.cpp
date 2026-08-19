class Solution {
    public:int matchPlayersAndTrainers(vector<int>& players,vector<int>& trainers){
        sort(players.begin(),players.end());
        sort(trainers.begin(),trainers.end());
        int player=0,matches=0;
        for(int trainer:trainers)if(player<(int)players.size()&&trainer>=players[player]){
            ++player;
            ++matches;
        }
        return matches;
    }
};
