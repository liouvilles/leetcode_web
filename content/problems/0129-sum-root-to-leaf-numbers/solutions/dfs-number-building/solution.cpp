class Solution {
    int dfs(TreeNode* node, int prefix) { if (!node) return 0; int current = prefix * 10 + node->val; if (!node->left && !node->right) return current; return dfs(node->left, current) + dfs(node->right, current); }
public:
    int sumNumbers(TreeNode* root) { return dfs(root, 0); }
};
