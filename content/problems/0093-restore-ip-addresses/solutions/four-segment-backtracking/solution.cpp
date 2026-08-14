class Solution {
    void backtrack(const string& s, int index, vector<string>& parts, vector<string>& answer) {
        int remainingParts = 4 - parts.size(), remainingChars = s.size() - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return;
        if (parts.size() == 4) { if (index == (int)s.size()) { string address = parts[0]; for (int i = 1; i < 4; ++i) address += "." + parts[i]; answer.push_back(address); } return; }
        int value = 0; for (int end = index; end < min(index + 3, (int)s.size()); ++end) { if (end > index && s[index] == '0') break; value = value * 10 + s[end] - '0'; if (value > 255) break; parts.push_back(s.substr(index, end - index + 1)); backtrack(s, end + 1, parts, answer); parts.pop_back(); }
    }
public:
    vector<string> restoreIpAddresses(string s) { vector<string> answer, parts; backtrack(s, 0, parts, answer); return answer; }
};
