class Solution {
    public: vector<int> xorQueries(vector<int>& arr,vector<vector<int>>& queries){
        vector<int> prefix(arr.size()+1);
        for(int i=0;i<(int)arr.size();++i)prefix[i+1]=prefix[i]^arr[i];
        vector<int> answer;
        for(auto& query:queries)answer.push_back(prefix[query[1]+1]^prefix[query[0]]);
        return answer;
    }
};
