class Solution {
    public:bool isAcronym(vector<string>& words,string s){
        if(words.size()!=s.size())return false;
        for(int i=0;i<(int)words.size();++i)if(words[i][0]!=s[i])return false;
        return true;
    }
};
