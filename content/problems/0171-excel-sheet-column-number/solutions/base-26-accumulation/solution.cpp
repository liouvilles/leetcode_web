class Solution {
public:
    int titleToNumber(string columnTitle) { int answer = 0; for (char value : columnTitle) answer = answer * 26 + value - 'A' + 1; return answer; }
};
