class Solution {
public:
    int lengthOfLastWord(string s) {
        int index = s.size() - 1; while (index >= 0 && s[index] == ' ') --index;
        int length = 0; while (index >= 0 && s[index] != ' ') { ++length; --index; }
        return length;
    }
};
