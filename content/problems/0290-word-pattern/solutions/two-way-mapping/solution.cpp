class Solution {
    public: bool wordPattern(string pattern,string s){
        vector<string> words;
        string word;
        stringstream stream(s);
        while(stream>>word)words.push_back(word);
        if(pattern.size()!=words.size())return false;
        unordered_map<char,string> forward;
        unordered_map<string,char> reverse;
        for(int i=0;i<(int)words.size();++i){
            char c=pattern[i];
            if(forward.count(c)&&forward[c]!=words[i])return false;
            if(reverse.count(words[i])&&reverse[words[i]]!=c)return false;
            forward[c]=words[i];
            reverse[words[i]]=c;
        }
        return true;
    }
};
