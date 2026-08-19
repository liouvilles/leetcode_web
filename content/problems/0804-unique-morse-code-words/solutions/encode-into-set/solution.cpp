class Solution {
    public: int uniqueMorseRepresentations(vector<string>& words){
        vector<string> code={
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        unordered_set<string> seen;
        for(string& word:words){
            string encoded;
            for(char c:word)encoded+=code[c-'a'];
            seen.insert(encoded);
        }
        return seen.size();
    }
};
