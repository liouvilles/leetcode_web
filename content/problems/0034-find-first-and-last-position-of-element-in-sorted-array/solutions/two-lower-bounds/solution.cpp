class Solution {
    int lowerBound(const vector<int>& nums, long long target) {
        int left = 0, right = nums.size();
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1; else right = middle; }
        return left;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = lowerBound(nums, target);
        if (first == (int)nums.size() || nums[first] != target) return {-1, -1};
        return {first, lowerBound(nums, (long long)target + 1) - 1};
    }
};
