class TweetCounts {
    unordered_map<string,map<int,int>> records;
    public:void recordTweet(string tweetName,int time){
        ++records[tweetName][time];
    }
    vector<int> getTweetCountsPerFrequency(string freq,string tweetName,int startTime,int endTime){
        int width=freq=="minute"?60:freq=="hour"?3600:86400;
        vector<int> answer((endTime-startTime)/width+1);
        auto& times=records[tweetName];
        for(auto it=times.lower_bound(startTime);it!=times.end()&&it->first<=endTime;++it)answer[(it->first-startTime)/width]+=it->second;
        return answer;
    }
};
