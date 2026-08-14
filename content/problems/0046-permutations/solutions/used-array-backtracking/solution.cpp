class Solution {
    void build(const vector<int>& nums, vector<bool>& used, vector<int>& path, vector<vector<int>>& answer) {
        if (path.size() == nums.size()) {
            answer.push_back(path);
            return;
        }
        for (int index = 0; index < (int)nums.size(); ++index) {
            if (used[index]) continue;
            used[index] = true;
            path.push_back(nums[index]);
            build(nums, used, path, answer);
            path.pop_back();
            used[index] = false;
        }
    }
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        vector<bool> used(nums.size());
        build(nums, used, path, answer);
        return answer;
    }
};
