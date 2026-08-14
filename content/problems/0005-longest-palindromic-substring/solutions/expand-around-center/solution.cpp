class Solution {
    int expand(const string& s, int left, int right) {
        while (left >= 0 && right < (int)s.size() && s[left] == s[right]) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
public:
    string longestPalindrome(string s) {
        int bestLeft = 0, bestRight = 0;
        for (int center = 0; center < (int)s.size(); ++center) {
            int length = max(expand(s, center, center), expand(s, center, center + 1));
            if (length > bestRight - bestLeft + 1) {
                bestLeft = center - (length - 1) / 2;
                bestRight = center + length / 2;
            }
        }
        return s.substr(bestLeft, bestRight - bestLeft + 1);
    }
};
