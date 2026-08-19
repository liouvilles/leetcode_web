class Solution {
    public:long long maximumImportance(int n,vector<vector<int>>& roads){
        vector<long long> degree(n);
        for(auto& road:roads){
            ++degree[road[0]];
            ++degree[road[1]];
        }
        sort(degree.begin(),degree.end());
        long long answer=0;
        for(int i=0;i<n;++i)answer+=degree[i]*(i+1);
        return answer;
    }
};
