class Solution {
public:
    string countAndSay(int n) {
        string answer = "1";
        for (int round = 1; round < n; ++round) { string next; for (int start = 0; start < (int)answer.size();) { int end = start + 1; while (end < (int)answer.size() && answer[end] == answer[start]) ++end; next += to_string(end - start); next += answer[start]; start = end; } answer = next; }
        return answer;
    }
};
