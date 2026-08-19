class Solution {
    public:int maximumNumberOfStringPairs(vector<string>& words){
        unordered_set<string> seen;
        int answer=0;
        for(string word:words){
            string reversed=word;
            reverse(reversed.begin(),reversed.end());
            if(seen.count(reversed))++answer;
            else seen.insert(word);
        }
        return answer;
    }
};
