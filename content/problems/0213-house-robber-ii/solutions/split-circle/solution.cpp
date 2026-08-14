class Solution {
    int linear(const vector<int>& nums, int start, int end) { int before = 0, previous = 0; for (int index = start; index <= end; ++index) { int current = max(previous, before + nums[index]); before = previous; previous = current; } return previous; }
public:
    int rob(vector<int>& nums) { if (nums.size() == 1) return nums[0]; return max(linear(nums, 0, nums.size() - 2), linear(nums, 1, nums.size() - 1)); }
};
