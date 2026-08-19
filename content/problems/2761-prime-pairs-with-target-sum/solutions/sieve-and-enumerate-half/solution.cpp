class Solution {
    public:vector<vector<int>> findPrimePairs(int n){
        vector<bool> prime(n+1,true);
        if(n>=0)prime[0]=false;
        if(n>=1)prime[1]=false;
        for(int value=2;value*value<=n;++value)if(prime[value])for(int multiple=value*value;multiple<=n;multiple+=value)prime[multiple]=false;
        vector<vector<int>> answer;
        for(int first=2;first<=n/2;++first)if(prime[first]&&prime[n-first])answer.push_back({
            first,n-first
        });
        return answer;
    }
};
