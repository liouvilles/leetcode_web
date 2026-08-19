class Solution {
    public: int minimumLengthEncoding(vector<string>& words){
        unordered_set<string> remaining(words.begin(),words.end());
        for(string& word:words)for(int start=1;start<(int)word.size();++start)remaining.erase(word.substr(start));
        int answer=0;
        for(string word:remaining)answer+=word.size()+1;
        return answer;
    }
};
