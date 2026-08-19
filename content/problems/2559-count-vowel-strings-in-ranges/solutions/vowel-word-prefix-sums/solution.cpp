class Solution {
    bool vowel(char character){
        return string("aeiou").find(character)!=string::npos;
    }
    public:vector<int> vowelStrings(vector<string>& words,vector<vector<int>>& queries){
        vector<int> prefix(words.size()+1);
        for(int i=0;i<(int)words.size();++i)prefix[i+1]=prefix[i]+(vowel(words[i].front())&&vowel(words[i].back()));
        vector<int> answer;
        for(auto& query:queries)answer.push_back(prefix[query[1]+1]-prefix[query[0]]);
        return answer;
    }
};
