class Solution {
    bool palindrome(const string& s, int left, int right) { while (left < right) if (s[left++] != s[right--]) return false; return true; }
    void backtrack(const string& s, int start, vector<string>& path, vector<vector<string>>& answer) { if (start == (int)s.size()) { answer.push_back(path); return; } for (int end = start; end < (int)s.size(); ++end) if (palindrome(s, start, end)) { path.push_back(s.substr(start, end - start + 1)); backtrack(s, end + 1, path, answer); path.pop_back(); } }
public:
    vector<vector<string>> partition(string s) { vector<vector<string>> answer; vector<string> path; backtrack(s, 0, path, answer); return answer; }
};
