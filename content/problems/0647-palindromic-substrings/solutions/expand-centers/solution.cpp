class Solution {
    int expand(const string& s, int left, int right) { int count = 0; while (left >= 0 && right < (int)s.size() && s[left] == s[right]) { ++count; --left; ++right; } return count; }
public:
    int countSubstrings(string s) { int answer = 0; for (int center = 0; center < (int)s.size(); ++center) answer += expand(s, center, center) + expand(s, center, center + 1); return answer; }
};
