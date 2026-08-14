class Solution {
    void backtrack(int start, const vector<int>& nums, vector<int>& path, vector<vector<int>>& answer) { answer.push_back(path); for (int index = start; index < (int)nums.size(); ++index) { if (index > start && nums[index] == nums[index - 1]) continue; path.push_back(nums[index]); backtrack(index + 1, nums, path, answer); path.pop_back(); } }
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) { sort(nums.begin(), nums.end()); vector<vector<int>> answer; vector<int> path; backtrack(0, nums, path, answer); return answer; }
};
