class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> last;
        int left = 0, best = 0;
        for (int right = 0; right < (int)s.size(); ++right) {
            if (last.count(s[right])) left = max(left, last[s[right]] + 1);
            last[s[right]] = right;
            best = max(best, right - left + 1);
        }
        return best;
    }
};
