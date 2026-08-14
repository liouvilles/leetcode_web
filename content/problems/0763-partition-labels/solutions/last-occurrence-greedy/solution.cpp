class Solution {
public:
    vector<int> partitionLabels(string s) {
        array<int, 26> last{}; for (int index = 0; index < (int)s.size(); ++index) last[s[index] - 'a'] = index;
        vector<int> answer; int start = 0, end = 0;
        for (int index = 0; index < (int)s.size(); ++index) { end = max(end, last[s[index] - 'a']); if (index == end) { answer.push_back(end - start + 1); start = index + 1; } }
        return answer;
    }
};
