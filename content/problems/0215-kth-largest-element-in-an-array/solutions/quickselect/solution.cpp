class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int target = nums.size() - k, left = 0, right = nums.size() - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) return nums[pivot];
            if (pivot < target) left = pivot + 1; else right = pivot - 1;
        }
        return -1;
    }

private:
    int partition(vector<int>& a, int left, int right) {
        int pick = left + rand() % (right - left + 1);
        swap(a[pick], a[right]);
        int store = left;
        for (int i = left; i < right; ++i) if (a[i] < a[right]) swap(a[store++], a[i]);
        swap(a[store], a[right]);
        return store;
    }
};
