class Solution {
    const vector<string> letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    void build(const string& digits, int index, string& path, vector<string>& answer) {
        if (index == (int)digits.size()) { answer.push_back(path); return; }
        for (char letter : letters[digits[index] - '0']) {
            path.push_back(letter);
            build(digits, index + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};
        vector<string> answer;
        string path;
        build(digits, 0, path, answer);
        return answer;
    }
};
