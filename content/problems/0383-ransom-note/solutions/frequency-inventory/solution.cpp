class Solution {
    public: bool canConstruct(string ransomNote,string magazine){
        array<int,26> counts{
        };
        for(char c:magazine)++counts[c-'a'];
        for(char c:ransomNote)if(--counts[c-'a']<0)return false;
        return true;
    }
};
