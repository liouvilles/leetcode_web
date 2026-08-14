class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end()); int best = nums[0] + nums[1] + nums[2];
        for (int first = 0; first + 2 < (int)nums.size(); ++first) { int left = first + 1, right = nums.size() - 1; while (left < right) { int sum = nums[first] + nums[left] + nums[right]; if (llabs((long long)sum - target) < llabs((long long)best - target)) best = sum; if (sum == target) return target; if (sum < target) ++left; else --right; } }
        return best;
    }
};
