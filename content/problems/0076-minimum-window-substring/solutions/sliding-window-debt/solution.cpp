class Solution {
public:
    string minWindow(string s, string t) {
        if (t.size() > s.size()) return "";
        array<int, 128> need{};
        for (unsigned char value : t) ++need[value];
        int missing = t.size(), left = 0, bestStart = 0, bestLength = INT_MAX;
        for (int right = 0; right < (int)s.size(); ++right) {
            unsigned char added = s[right];
            if (need[added] > 0) --missing;
            --need[added];
            while (missing == 0) {
                int length = right - left + 1;
                if (length < bestLength) { bestLength = length; bestStart = left; }
                unsigned char removed = s[left++];
                ++need[removed];
                if (need[removed] > 0) ++missing;
            }
        }
        return bestLength == INT_MAX ? "" : s.substr(bestStart, bestLength);
    }
};
