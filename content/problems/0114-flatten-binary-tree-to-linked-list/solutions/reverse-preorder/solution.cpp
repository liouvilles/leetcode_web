class Solution {
    TreeNode* previous = nullptr;
public:
    void flatten(TreeNode* root) { if (!root) return; flatten(root->right); flatten(root->left); root->right = previous; root->left = nullptr; previous = root; }
};
