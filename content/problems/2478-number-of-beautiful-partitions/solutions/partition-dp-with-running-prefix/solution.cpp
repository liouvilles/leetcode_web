class Solution {
    static const int MOD=1'000'000'007;
    bool prime(char digit){
        return digit=='2'||digit=='3'||digit=='5'||digit=='7';
    }
    public:int beautifulPartitions(string s,int k,int minLength){
        int n=s.size();
        if(!prime(s[0])||prime(s[n-1]))return 0;
        auto boundary=[&](int position){
            return position==0||position==n||(!prime(s[position-1])&&prime(s[position]));
        };
        vector<long long> dp(n+1);
        dp[0]=1;
        while(k--){
            vector<long long> next(n+1);
            long long running=0;
            for(int end=1;end<=n;++end){
                int start=end-minLength;
                if(start>=0&&boundary(start))running=(running+dp[start])%MOD;
                if(boundary(end))next[end]=running;
            }
            dp.swap(next);
        }
        return dp[n];
    }
};
