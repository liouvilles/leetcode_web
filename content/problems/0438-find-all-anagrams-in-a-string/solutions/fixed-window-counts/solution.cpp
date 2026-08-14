class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (p.size() > s.size()) return {};
        array<int, 26> target{}, window{}; for (char value : p) ++target[value - 'a']; vector<int> answer;
        for (int right = 0; right < (int)s.size(); ++right) { ++window[s[right] - 'a']; if (right >= (int)p.size()) --window[s[right - p.size()] - 'a']; if (right >= (int)p.size() - 1 && target == window) answer.push_back(right - p.size() + 1); }
        return answer;
    }
};
