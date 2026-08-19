class Solution {
    public:long long appealSum(string s){
        int last[26];
        fill(begin(last),end(last),-1);
        long long current=0,answer=0;
        for(int i=0;i<(int)s.size();++i){
            int ch=s[i]-'a';
            current+=i-last[ch];
            last[ch]=i;
            answer+=current;
        }
        return answer;
    }
};
