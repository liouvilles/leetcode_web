class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        int beforePrevious = 1, previous = 1;
        for (int index = 1; index < (int)s.size(); ++index) { int current = s[index] == '0' ? 0 : previous; int pair = (s[index - 1] - '0') * 10 + s[index] - '0'; if (pair >= 10 && pair <= 26) current += beforePrevious; beforePrevious = previous; previous = current; }
        return previous;
    }
};
