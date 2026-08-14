class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return nullptr;
        queue<TreeNode*> nodes;
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode* node = nodes.front(); nodes.pop();
            swap(node->left, node->right);
            if (node->left) nodes.push(node->left);
            if (node->right) nodes.push(node->right);
        }
        return root;
    }
};
