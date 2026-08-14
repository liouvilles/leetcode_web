class Solution {
    bool mirror(TreeNode* left, TreeNode* right) {
        if (!left || !right) return left == right;
        return left->val == right->val
            && mirror(left->left, right->right)
            && mirror(left->right, right->left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        return !root || mirror(root->left, root->right);
    }
};
