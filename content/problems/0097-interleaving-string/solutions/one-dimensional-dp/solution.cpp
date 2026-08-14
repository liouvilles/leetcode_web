class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.size() + s2.size() != s3.size()) return false; vector<bool> dp(s2.size() + 1); dp[0] = true;
        for (int i = 0; i <= (int)s1.size(); ++i) for (int j = 0; j <= (int)s2.size(); ++j) { if (i == 0 && j == 0) continue; bool first = i > 0 && dp[j] && s1[i - 1] == s3[i + j - 1]; bool second = j > 0 && dp[j - 1] && s2[j - 1] == s3[i + j - 1]; dp[j] = first || second; } return dp[s2.size()];
    }
};
