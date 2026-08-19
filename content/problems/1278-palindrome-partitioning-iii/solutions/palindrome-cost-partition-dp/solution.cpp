class Solution {
    string text;
    int n;
    vector<vector<int>> cost,memo;
    int dfs(int index,int parts){
        if(parts==1)return cost[index][n-1];
        int& result=memo[index][parts];
        if(result>=0)return result;
        result=1000000;
        for(int end=index;end<=n-parts;++end)result=min(result,cost[index][end]+dfs(end+1,parts-1));
        return result;
    }
    public:int palindromePartition(string s,int k){
        text=s;
        n=s.size();
        cost.assign(n,vector<int>(n));
        for(int length=2;length<=n;++length)for(int left=0;left+length<=n;++left){
            int right=left+length-1;
            cost[left][right]=(length>2?cost[left+1][right-1]:0)+(s[left]!=s[right]);
        }
        memo.assign(n,vector<int>(k+1,-1));
        return dfs(0,k);
    }
};
