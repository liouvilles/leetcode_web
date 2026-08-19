class Solution {
    public: int maxSumAfterPartitioning(vector<int>& arr,int k){
        vector<int> dp(arr.size()+1);
        for(int i=1;i<=(int)arr.size();++i){
            int maximum=0;
            for(int length=1;length<=min(k,i);++length){
                maximum=max(maximum,arr[i-length]);
                dp[i]=max(dp[i],dp[i-length]+maximum*length);
            }
        }
        return dp.back();
    }
};
