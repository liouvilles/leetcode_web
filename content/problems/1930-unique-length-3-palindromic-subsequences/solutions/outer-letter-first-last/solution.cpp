class Solution {
    public: int countPalindromicSubsequence(string s){
        int first[26],last[26]={
        };
        fill(first,first+26,-1);
        for(int i=0;i<(int)s.size();++i){
            int value=s[i]-'a';
            if(first[value]<0)first[value]=i;
            last[value]=i;
        }
        int answer=0;
        for(int value=0;value<26;++value)if(first[value]+1<last[value]){
            bool middle[26]={
            };
            for(int i=first[value]+1;i<last[value];++i)middle[s[i]-'a']=true;
            answer+=count(middle,middle+26,true);
        }
        return answer;
    }
};
