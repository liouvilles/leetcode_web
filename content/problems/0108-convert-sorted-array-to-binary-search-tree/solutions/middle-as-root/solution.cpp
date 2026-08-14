class Solution {
    TreeNode* build(vector<int>& nums, int left, int right) { if (left > right) return nullptr; int middle = left + (right - left) / 2; TreeNode* root = new TreeNode(nums[middle]); root->left = build(nums, left, middle - 1); root->right = build(nums, middle + 1, right); return root; }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) { return build(nums, 0, nums.size() - 1); }
};
