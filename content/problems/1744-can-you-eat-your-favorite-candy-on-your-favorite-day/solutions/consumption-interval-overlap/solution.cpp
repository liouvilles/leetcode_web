class Solution {
    public: vector<bool> canEat(vector<int>& candiesCount,vector<vector<int>>& queries){
        vector<long long> prefix(candiesCount.size()+1);
        for(int i=0;i<(int)candiesCount.size();++i)prefix[i+1]=prefix[i]+candiesCount[i];
        vector<bool> answer;
        for(auto& query:queries){
            long long minimum=query[1]+1LL,maximum=minimum*query[2];
            int type=query[0];
            answer.push_back(maximum>prefix[type]&&minimum<=prefix[type+1]);
        }
        return answer;
    }
};
