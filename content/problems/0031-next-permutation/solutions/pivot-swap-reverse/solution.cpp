class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int pivot = (int)nums.size() - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) --pivot;
        if (pivot >= 0) {
            int greater = nums.size() - 1;
            while (nums[greater] <= nums[pivot]) --greater;
            swap(nums[pivot], nums[greater]);
        }
        reverse(nums.begin() + pivot + 1, nums.end());
    }
};
