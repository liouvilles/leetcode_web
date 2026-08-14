class Solution {
public:
    bool isSameTree(TreeNode* first, TreeNode* second) {
        if (!first || !second) return first == second;
        return first->val == second->val && isSameTree(first->left, second->left) && isSameTree(first->right, second->right);
    }
};
