class Solution {
    void backtrack(int start, int n, int k, vector<int>& path, vector<vector<int>>& answer) {
        if ((int)path.size() == k) { answer.push_back(path); return; }
        int limit = n - (k - path.size()) + 1;
        for (int value = start; value <= limit; ++value) { path.push_back(value); backtrack(value + 1, n, k, path, answer); path.pop_back(); }
    }
public:
    vector<vector<int>> combine(int n, int k) { vector<vector<int>> answer; vector<int> path; backtrack(1, n, k, path, answer); return answer; }
};
