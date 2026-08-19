class Solution {
    public: string toGoatLatin(string sentence){
        unordered_set<char> vowels={
            'a','e','i','o','u','A','E','I','O','U'
        };
        stringstream stream(sentence);
        string word,answer;
        int index=1;
        while(stream>>word){
            if(!vowels.count(word[0]))word=word.substr(1)+word[0];
            if(!answer.empty())answer+=' ';
            answer+=word+"ma"+string(index++,'a');
        }
        return answer;
    }
};
