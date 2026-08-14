class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s1.size() > s2.size()) return false;
        array<int, 26> target{}, window{};
        for (int index = 0; index < (int)s1.size(); ++index) { ++target[s1[index] - 'a']; ++window[s2[index] - 'a']; }
        for (int left = 0; left <= (int)s2.size() - (int)s1.size(); ++left) { if (target == window) return true; int next = left + s1.size(); if (next < (int)s2.size()) { --window[s2[left] - 'a']; ++window[s2[next] - 'a']; } }
        return false;
    }
};
