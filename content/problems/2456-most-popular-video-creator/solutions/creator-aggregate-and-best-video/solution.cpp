class Solution {
    public:vector<vector<string>> mostPopularCreator(vector<string>& creators,vector<string>& ids,vector<int>& views){
        unordered_map<string,long long> total;
        unordered_map<string,int> bestViews;
        unordered_map<string,string> bestId;
        for(int i=0;i<(int)creators.size();++i){
            string creator=creators[i];
            total[creator]+=views[i];
            if(!bestViews.count(creator)||views[i]>bestViews[creator]||(views[i]==bestViews[creator]&&ids[i]<bestId[creator])){
                bestViews[creator]=views[i];
                bestId[creator]=ids[i];
            }
        }
        long long maximum=0;
        for(auto [creator,value]:total)maximum=max(maximum,value);
        vector<vector<string>> answer;
        for(auto [creator,value]:total)if(value==maximum)answer.push_back({
            creator,bestId[creator]
        });
        return answer;
    }
};
