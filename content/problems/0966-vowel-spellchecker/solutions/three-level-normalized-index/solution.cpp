class Solution {
    string mask(string word){
        for(char& ch:word)if(string("aeiou").find(ch)!=string::npos)ch='*';
        return word;
    }
    public:vector<string> spellchecker(vector<string>& wordlist,vector<string>& queries){
        unordered_set<string> exact(wordlist.begin(),wordlist.end());
        unordered_map<string,string> lower,vowel;
        for(string word:wordlist){
            string normalized=word;
            transform(normalized.begin(),normalized.end(),normalized.begin(),::tolower);
            if(!lower.count(normalized))lower[normalized]=word;
            string key=mask(normalized);
            if(!vowel.count(key))vowel[key]=word;
        }
        vector<string> answer;
        for(string query:queries){
            string normalized=query;
            transform(normalized.begin(),normalized.end(),normalized.begin(),::tolower);
            if(exact.count(query))answer.push_back(query);
            else if(lower.count(normalized))answer.push_back(lower[normalized]);
            else answer.push_back(vowel.count(mask(normalized))?vowel[mask(normalized)]:"");
        }
        return answer;
    }
};
