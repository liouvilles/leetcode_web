class Solution {
    void search(const vector<int>& candidates, int remaining, int start, vector<int>& path, vector<vector<int>>& answer) {
        if (remaining == 0) {
            answer.push_back(path);
            return;
        }
        for (int index = start; index < (int)candidates.size() && candidates[index] <= remaining; ++index) {
            path.push_back(candidates[index]);
            search(candidates, remaining - candidates[index], index, path, answer);
            path.pop_back();
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> answer;
        vector<int> path;
        search(candidates, target, 0, path, answer);
        return answer;
    }
};
