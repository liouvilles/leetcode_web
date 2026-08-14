class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        const string& first = strs[0];
        for (int index = 0; index < (int)first.size(); ++index) for (int item = 1; item < (int)strs.size(); ++item) if (index == (int)strs[item].size() || strs[item][index] != first[index]) return first.substr(0, index);
        return first;
    }
};
