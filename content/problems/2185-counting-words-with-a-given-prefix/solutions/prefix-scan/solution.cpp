class Solution {
    public:int prefixCount(vector<string>& words,string pref){
        return count_if(words.begin(),words.end(),[&](string& word){
            return word.rfind(pref,0)==0;
        });
    }
};
