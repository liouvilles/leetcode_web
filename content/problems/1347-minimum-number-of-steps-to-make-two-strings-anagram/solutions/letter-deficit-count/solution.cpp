class Solution {
    public: int minSteps(string s,string t){
        int count[26]={
        };
        for(int i=0;i<(int)s.size();++i){
            ++count[s[i]-'a'];
            --count[t[i]-'a'];
        }
        int answer=0;
        for(int value:count)answer+=max(0,value);
        return answer;
    }
};
