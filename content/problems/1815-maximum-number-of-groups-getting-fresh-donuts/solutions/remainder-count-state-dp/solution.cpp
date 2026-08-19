class Solution {
    int batchSize;
    unordered_map<long long,int> memo;
    int dfs(long long state,int current){
        if(!state)return 0;
        long long key=state*batchSize+current;
        if(memo.count(key))return memo[key];
        int best=0;
        for(int remainder=1;remainder<batchSize;++remainder){
            int shift=(remainder-1)*5;
            if(!((state>>shift)&31))continue;
            best=max(best,(!current)+dfs(state-(1LL<<shift),(current+remainder)%batchSize));
        }
        return memo[key]=best;
    }
    public:int maxHappyGroups(int inputBatchSize,vector<int>& groups){
        batchSize=inputBatchSize;
        memo.clear();
        vector<int> count(batchSize);
        for(int group:groups)++count[group%batchSize];
        long long state=0;
        for(int remainder=1;remainder<batchSize;++remainder)state|=1LL*count[remainder]<<((remainder-1)*5);
        return count[0]+dfs(state,0);
    }
};
