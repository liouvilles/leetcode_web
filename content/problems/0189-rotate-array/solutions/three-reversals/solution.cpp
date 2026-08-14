class Solution {
    void reverseRange(vector<int>& nums, int left, int right) { while (left < right) swap(nums[left++], nums[right--]); }
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverseRange(nums, 0, nums.size() - 1); reverseRange(nums, 0, k - 1); reverseRange(nums, k, nums.size() - 1);
    }
};
