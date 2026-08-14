class Solution {
public:
    string reverseWords(string s) {
        stringstream stream(s); vector<string> words; string word; while (stream >> word) words.push_back(word);
        reverse(words.begin(), words.end()); string answer;
        for (int index = 0; index < (int)words.size(); ++index) { if (index) answer.push_back(' '); answer += words[index]; }
        return answer;
    }
};
