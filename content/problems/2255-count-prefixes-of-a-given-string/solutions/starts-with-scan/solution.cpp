class Solution {
    public:int countPrefixes(vector<string>& words,string s){
        return count_if(words.begin(),words.end(),[&](string& word){
            return s.rfind(word,0)==0;
        });
    }
};
