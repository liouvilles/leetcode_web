class Solution {
    public:bool isSubstringPresent(string s){
        bool seen[26][26]={
        };
        for(int index=0;index+1<(int)s.size();++index){
            int first=s[index]-'a',second=s[index+1]-'a';
            seen[first][second]=true;
            if(seen[second][first])return true;
        }
        return false;
    }
};
