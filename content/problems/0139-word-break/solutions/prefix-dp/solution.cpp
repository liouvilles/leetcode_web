class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> words(wordDict.begin(), wordDict.end());
        vector<bool> possible(s.size() + 1);
        possible[0] = true;
        for (int end = 1; end <= (int)s.size(); ++end) {
            for (int start = 0; start < end; ++start) {
                if (possible[start] && words.count(s.substr(start, end - start))) {
                    possible[end] = true;
                    break;
                }
            }
        }
        return possible[s.size()];
    }
};
