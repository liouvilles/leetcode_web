class Solution {
    public: bool closeStrings(string word1,string word2){
        if(word1.size()!=word2.size())return false;
        array<int,26> first{
        },second{
        };
        for(char letter:word1)++first[letter-'a'];
        for(char letter:word2)++second[letter-'a'];
        for(int i=0;i<26;++i)if((first[i]==0)!=(second[i]==0))return false;
        sort(first.begin(),first.end());
        sort(second.begin(),second.end());
        return first==second;
    }
};
