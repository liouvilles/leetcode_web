class Solution {
    public: vector<int> platesBetweenCandles(string s,vector<vector<int>>& queries){
        int n=s.size(),candle=-1;
        vector<int> prefix(n+1),left(n),right(n);
        for(int i=0;i<n;++i){
            prefix[i+1]=prefix[i]+(s[i]=='*');
            if(s[i]=='|')candle=i;
            left[i]=candle;
        }
        candle=-1;
        for(int i=n-1;i>=0;--i){
            if(s[i]=='|')candle=i;
            right[i]=candle;
        }
        vector<int> answer;
        for(auto& query:queries){
            int start=right[query[0]],end=left[query[1]];
            answer.push_back(start>=0&&start<end?prefix[end]-prefix[start]:0);
        }
        return answer;
    }
};
