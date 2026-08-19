class Solution {
    public: int countGoodSubstrings(string s){
        int answer=0;
        for(int i=0;i+2<(int)s.size();++i)if(s[i]!=s[i+1]&&s[i]!=s[i+2]&&s[i+1]!=s[i+2])++answer;
        return answer;
    }
};
