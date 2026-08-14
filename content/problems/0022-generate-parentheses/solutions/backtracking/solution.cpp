class Solution {
    void build(int n, int open, int close, string& path, vector<string>& answer) {
        if ((int)path.size() == 2 * n) {
            answer.push_back(path);
            return;
        }
        if (open < n) {
            path.push_back('(');
            build(n, open + 1, close, path, answer);
            path.pop_back();
        }
        if (close < open) {
            path.push_back(')');
            build(n, open, close + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<string> generateParenthesis(int n) {
        vector<string> answer;
        string path;
        build(n, 0, 0, path, answer);
        return answer;
    }
};
