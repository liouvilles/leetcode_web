class Solution {
public:
    string convertToTitle(int columnNumber) { string answer; while (columnNumber > 0) { --columnNumber; answer += char('A' + columnNumber % 26); columnNumber /= 26; } reverse(answer.begin(), answer.end()); return answer; }
};
