class Solution {
    int distance(int a,int b){
        if(a==26||b==26)return 0;
        return abs(a/6-b/6)+abs(a%6-b%6);
    }
    public:int minimumDistance(string word){
        const int INF=1000000;
        vector<int> dp(27,INF);
        dp[26]=0;
        for(int i=1;i<(int)word.size();++i){
            int current=word[i-1]-'A',target=word[i]-'A';
            vector<int> next(27,INF);
            for(int other=0;other<=26;++other)if(dp[other]<INF){
                next[other]=min(next[other],dp[other]+distance(current,target));
                next[current]=min(next[current],dp[other]+distance(other,target));
            }
            dp.swap(next);
        }
        return *min_element(dp.begin(),dp.end());
    }
};
