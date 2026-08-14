class Solution {
    int diameter = 0;
    int height(TreeNode* node) { if (!node) return 0; int left = height(node->left), right = height(node->right); diameter = max(diameter, left + right); return max(left, right) + 1; }
public:
    int diameterOfBinaryTree(TreeNode* root) { diameter = 0; height(root); return diameter; }
};
