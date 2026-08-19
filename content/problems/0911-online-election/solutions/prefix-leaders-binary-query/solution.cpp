class TopVotedCandidate {
    vector<int> times,leaders;
    public:TopVotedCandidate(vector<int>& persons,vector<int>& inputTimes):times(inputTimes),leaders(persons.size()){
        unordered_map<int,int> counts;
        int leader=-1,leaderVotes=0;
        for(int i=0;i<(int)persons.size();++i){
            int votes=++counts[persons[i]];
            if(votes>=leaderVotes){
                leader=persons[i];
                leaderVotes=votes;
            }
            leaders[i]=leader;
        }
    }
    int q(int t){
        int index=upper_bound(times.begin(),times.end(),t)-times.begin()-1;
        return leaders[index];
    }
};
