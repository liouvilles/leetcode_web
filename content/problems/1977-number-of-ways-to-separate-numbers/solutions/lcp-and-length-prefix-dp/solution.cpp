class Solution {
    static const int MOD=1000000007;
    string value;
    vector<vector<unsigned short>> lcp;
    bool lessOrEqual(int first,int second,int length){
        int common=lcp[first][second];
        return common>=length||value[first+common]<=value[second+common];
    }
    public: int numberOfCombinations(string num){
        if(num[0]=='0')return 0;
        value=num;
        int n=num.size();
        lcp.assign(n+1,vector<unsigned short>(n+1));
        for(int first=n-1;first>=0;--first)for(int second=n-1;second>=0;--second)if(num[first]==num[second])lcp[first][second]=lcp[first+1][second+1]+1;
        vector<vector<int>> prefix(n+1,vector<int>(n+1));
        for(int end=1;end<=n;++end)for(int length=1;length<=end;++length){
            int start=end-length;
            long long ways=0;
            if(num[start]!='0'){
                if(!start)ways=1;
                else{
                    ways=prefix[start][min(length-1,start)];
                    if(length<=start&&lessOrEqual(start-length,start,length)){
                        int equal=prefix[start][length]-prefix[start][length-1];
                        if(equal<0)equal+=MOD;
                        ways+=equal;
                    }
                }
            }
            prefix[end][length]=(prefix[end][length-1]+ways)%MOD;
        }
        return prefix[n][n];
    }
};
