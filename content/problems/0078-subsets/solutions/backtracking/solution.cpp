class Solution {
    void build(const vector<int>& nums, int start, vector<int>& path, vector<vector<int>>& answer) {
        answer.push_back(path);
        for (int index = start; index < (int)nums.size(); ++index) {
            path.push_back(nums[index]);
            build(nums, index + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        build(nums, 0, path, answer);
        return answer;
    }
};
