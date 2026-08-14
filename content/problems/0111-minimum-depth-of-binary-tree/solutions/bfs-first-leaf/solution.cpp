class Solution {
public:
    int minDepth(TreeNode* root) { if (!root) return 0; queue<TreeNode*> nodes; nodes.push(root); int depth = 0; while (!nodes.empty()) { ++depth; for (int size = nodes.size(); size > 0; --size) { TreeNode* node = nodes.front(); nodes.pop(); if (!node->left && !node->right) return depth; if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } } return depth; }
};
