class Solution {
    public: int lenLongestFibSubseq(vector<int>& arr){
        unordered_map<int,int> index;
        for(int i=0;i<(int)arr.size();++i)index[arr[i]]=i;
        vector<vector<int>> dp(arr.size(),vector<int>(arr.size()));
        int answer=0;
        for(int i=0;i<(int)arr.size();++i)for(int j=0;j<i;++j){
            int previous=arr[i]-arr[j];
            if(previous<arr[j]&&index.count(previous)){
                int k=index[previous];
                dp[j][i]=max(3,dp[k][j]+1);
                answer=max(answer,dp[j][i]);
            }
        }
        return answer;
    }
};
