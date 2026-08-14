class Solution {
public:
    int longestCommonSubsequence(string first, string second) {
        vector<vector<int>> length(first.size() + 1, vector<int>(second.size() + 1));
        for (int i = 1; i <= (int)first.size(); ++i) for (int j = 1; j <= (int)second.size(); ++j) length[i][j] = first[i - 1] == second[j - 1] ? length[i - 1][j - 1] + 1 : max(length[i - 1][j], length[i][j - 1]);
        return length[first.size()][second.size()];
    }
};
